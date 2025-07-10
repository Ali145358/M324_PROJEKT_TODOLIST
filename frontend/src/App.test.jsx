import { render, screen, fireEvent, waitFor, act } from '@testing-library/react';
import { describe, it, expect, beforeEach, afterEach, vi } from 'vitest';
import App from './App';

// Simuliert eine kleine In-Memory-Datenbank für die Tests
let mockTasks = [];

// Mock für die globale fetch-Funktion
beforeEach(() => {
  // Setzt die Mock-Datenbank vor jedem Test zurück
  mockTasks = [];
  let nextId = 1;

  global.fetch = vi.fn((url, options) => {
    const urlObject = new URL(url);

    // Mock für das Hinzufügen von Tasks (POST /api/v1/tasks)
    if (urlObject.pathname.endsWith('/tasks') && options?.method === 'POST') {
      const body = JSON.parse(options.body);
      const newTask = { id: nextId++, taskdescription: body.taskdescription };
      mockTasks.push(newTask);
      return Promise.resolve({ ok: true, json: () => Promise.resolve(mockTasks) });
    }

    // Mock für das Löschen von Tasks (POST /api/v1/delete)
    if (urlObject.pathname.endsWith('/delete') && options?.method === 'POST') {
      const body = JSON.parse(options.body);
      mockTasks = mockTasks.filter(task => task.taskdescription !== body.taskdescription);
      return Promise.resolve({ ok: true, json: () => Promise.resolve(mockTasks) });
    }

    // Mock für das Abrufen aller Tasks (GET /api/v1/)
    if (urlObject.pathname.endsWith('/api/v1/') && options?.method !== 'POST') {
      return Promise.resolve({ ok: true, json: () => Promise.resolve(mockTasks) });
    }

    // Fallback für unerwartete Anfragen
    return Promise.reject(new Error(`Unmocked fetch call: ${options?.method} ${url}`));
  });
});

afterEach(() => {
  vi.restoreAllMocks();
});

describe('App component', () => {
  it('renders heading', async () => {
    await act(async () => {
      render(<App />);
    });
    const headingElement = screen.getByRole('heading', { name: /ToDo Liste/i });
    expect(headingElement).toBeInTheDocument();
  });

  it('renders with initial state', async () => {
    await act(async () => {
      render(<App />);
    });
    const inputElement = screen.getByLabelText('Neues Todo anlegen:');
    const addButtonElement = screen.getByRole('button', { name: /Absenden/i });

    expect(inputElement).toHaveValue('');
    expect(addButtonElement).toBeInTheDocument();
  });

  it('allows user to add a new task', async () => {
    await act(async () => {
      render(<App />);
    });
    const inputElement = screen.getByLabelText('Neues Todo anlegen:');
    const addButtonElement = screen.getByRole('button', { name: /Absenden/i });

    fireEvent.change(inputElement, { target: { value: 'Buy_groceries' } });
    fireEvent.click(addButtonElement);

    await waitFor(() => {
      expect(screen.getByText(/Buy_groceries/)).toBeInTheDocument();
    });
  });

  it('allows user to add multiple tasks', async () => {
    await act(async () => {
      render(<App />);
    });
    const inputElement = screen.getByLabelText('Neues Todo anlegen:');
    const addButtonElement = screen.getByRole('button', { name: /Absenden/i });

    fireEvent.change(inputElement, { target: { value: 'Buy_groceries' } });
    fireEvent.click(addButtonElement);

    fireEvent.change(inputElement, { target: { value: 'Do_laundry' } });
    fireEvent.click(addButtonElement);

    await waitFor(() => {
      expect(screen.getByText(/Buy_groceries/)).toBeInTheDocument();
      expect(screen.getByText(/Do_laundry/)).toBeInTheDocument();
    });
  });
});
