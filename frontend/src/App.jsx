import { useState, useEffect } from 'react';
import './App.css';

// Trash Can Icon Component
const TrashIcon = () => (
  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round">
    <polyline points="3 6 5 6 21 6"></polyline>
    <path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path>
    <line x1="10" y1="11" x2="10" y2="17"></line>
    <line x1="14" y1="11" x2="14" y2="17"></line>
  </svg>
);

function App() {
  const [taskDescription, setTaskDescription] = useState('');
  const [tasks, setTasks] = useState([]);

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

    fetch('http://localhost:8080/api/v1/tasks', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(newTask),
    })
      .then((res) => res.json())
      .then((data) => {
        setTasks(data);
        setTaskDescription('');
      })
      .catch((err) => console.error('Fehler beim Erstellen der Aufgabe:', err));
  };

  const handleDelete = (description) => {
    const taskToDelete = {
      taskdescription: description,
    };

    fetch(`http://localhost:8080/api/v1/delete`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(taskToDelete),
    })
      .then((res) => res.json())
      .then((data) => {
        setTasks(data);
      })
      .catch((err) => console.error('Fehler beim Löschen der Aufgabe:', err));
  };

  return (
    <div className="App">
      <div className="todo-container">
        <h1>To-Do List</h1>
        <form className="todo-form" onSubmit={handleSubmit}>
          <input
            type="text"
            value={taskDescription}
            onChange={(e) => setTaskDescription(e.target.value)}
            placeholder="Neue Aufgabe hinzufügen..."
          />
          <button type="submit">Hinzufügen</button>
        </form>
        <ul className="todo-list">
          {tasks.map((task) => (
            <li key={task.taskdescription} className="todo-item">
              <span>{task.taskdescription}</span>
              <button
                onClick={() => handleDelete(task.taskdescription)}
                className="delete-button"
                aria-label={`Lösche ${task.taskdescription}`}
              >
                <TrashIcon />
              </button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default App;

