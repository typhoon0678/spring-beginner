import {Link, useParams} from "react-router-dom";
import {useState} from "react";
import {retrieveHelloWorldPathVariable} from "./api/HelloWorldApiService";
import {useAuth} from "./security/AuthContext";

export default function WelcomeComponent() {

    const {username} = useParams();

    const authContext = useAuth();

    const [message, setMessage] = useState(null);

    function callHelloWorldRestApi() {

        retrieveHelloWorldPathVariable(authContext.username, authContext.token)
            .then(response => successfulResponse(response))
            .catch(response => errorResponse(response))
            .finally(() => console.log("cleanup"));

    }

    function successfulResponse(response) {
        setMessage(response.data.message);
    }

    function errorResponse(error) {
        console.log(error);
    }

    return (
        <div className="Welcome">
            <h1>Welcome {username}</h1>
            <div>
                Manage your todos. <Link to="/todos">Go here</Link>
            </div>
            <div>
                <button className="btn btn-success m-5" onClick={callHelloWorldRestApi}>
                    Call Hello World
                </button>
            </div>
            <div className="text-info">{message}</div>
        </div>
    )
}