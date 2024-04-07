import {useEffect, useState} from "react";
import {deleteTodoApi, retrieveAllTodosForUsernameApi} from "./api/TodoApiService";
import {useAuth} from "./security/AuthContext";
import {useNavigate} from "react-router-dom";

export default function ListTodosComponent() {

    const authContext = useAuth();
    const navigate = useNavigate();

    const [todos, setTodos] = useState([]);
    const [message, setMessage] = useState(null);

    useEffect(() => {
        refreshTodos();
    }, []);

    function refreshTodos() {
        retrieveAllTodosForUsernameApi(authContext.username)
            .then(response => {
                console.log(response);
                setTodos(response.data)
            })
            .catch(response => console.log(response));
    }

    function deleteTodo(id) {
        deleteTodoApi(authContext.username, id)
            .then(
                () => {
                    setMessage(`Delete of todo with id = ${id} successful`);
                }
            );
    }

    function updateTodo(id) {
        navigate(`/todos/${id}`);
    }

    function addNewTodo() {
        navigate(`/todos/-1`)
    }

    return (
        <div className="container">
            <h1>Things You Want To Do!</h1>
            {message && <div className="alert alert-warning">{message}</div>}
            <div>
                <table className="table">
                    <thead>
                    <tr>
                        <th>description</th>
                        <th>id Done?</th>
                        <th>Target Date</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        todos.map((todo) => (
                            <tr key={todo.id}>
                                <td>{todo.description}</td>
                                <td>{todo.done.toString()}</td>
                                {/*<td>{todo.targetDate.toDateString()}</td>*/}
                                <td>{todo.targetDate.toString()}</td>
                                <td>
                                    <button className="btn btn-warning" onClick={() => deleteTodo(todo.id)}>Delete
                                    </button>
                                </td>
                                <td>
                                    <button className="btn btn-success" onClick={() => updateTodo(todo.id)}>Update
                                    </button>
                                </td>
                            </tr>))
                    }
                    </tbody>
                </table>
            </div>
            <div className="btn btn-success m-5" onClick={addNewTodo}>Add New Todo</div>
        </div>
    )
}
