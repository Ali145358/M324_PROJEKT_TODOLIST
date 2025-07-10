import { useState, useEffect } from 'react';
import './App.css';

function App() {
  const [taskDescription, setTaskDescription] = useState('');
  const [tasks, setTasks] = useState([]);

  // Holt die Tasks vom Backend, wenn die Komponente geladen wird
  const fetchTasks = () => {
    fetch('http://localhost:8080/api/v1/')
      .then((res) => res.json())
      .then((data) => setTasks(data))
      .catch((err) => console.error('Fehler beim Laden der Tasks:', err));
  };

  useEffect(() => {
    fetchTasks();
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (!taskDescription.trim()) return;

    const newTask = {
      taskdescription: taskDescription.trim(),
    };

    // Sendet den neuen Task an das Backend
    fetch('http://localhost:8080/api/v1/tasks', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(newTask),
    })
      .then((res) => res.json()) // Get the updated list from the response
      .then((data) => {
        setTasks(data); // Set the new list
        setTaskDescription('');
      })
      .catch((err) => {
        console.error('Fehler beim Erstellen der Aufgabe:', err);
      });
  };

  // Löschen-Handler: sendet die zu löschende Aufgabe an das Backend
  const handleDelete = (description) => {
    const taskToDelete = {
      taskdescription: description,
    };

    fetch(`http://localhost:8080/api/v1/delete`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(taskToDelete), // Sendet das Task-Objekt
    })
      .then((res) => res.json()) // Get the updated list from the response
      .then((data) => {
        setTasks(data); // Set the new list
      })
      .catch((err) =>
        console.error('Fehler beim Löschen der Aufgabe:', err)
      );
  };

  return (
    <div className="App">
      <header className="App-header">
        <img src="/src/assets/react.svg" className="App-logo" alt="logo" />
        <h1>ToDo Liste </h1>
        <div className="todo-container">
          <form className="todo-form" onSubmit={handleSubmit}>
            <label htmlFor="taskdescription">Neues Todo anlegen:</label>
            <input
              id="taskdescription"
              type="text"
              value={taskDescription}
              onChange={(e) => setTaskDescription(e.target.value)}
            />
            <button type="submit">Absenden</button>
          </form>
          <ul className="todo-list">
            {tasks.map((task) => (
              <li key={task.taskdescription} className="todo-item">
                {task.taskdescription}
                <button
                  onClick={() => handleDelete(task.taskdescription)} // Übergibt die Beschreibung
                  aria-label="Löschen"
                  className="delete-button"
                >
                  delete
                </button>
              </li>
            ))}
          </ul>
        </div>
      </header>
    </div>
  );
}

export default App;

