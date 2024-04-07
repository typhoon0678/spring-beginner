import {createContext, useContext, useState} from "react";
import {apiClient} from "../api/ApiClient";
import {executeJwtAuthenticationService} from "../api/AuthenticationApiService";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({children}) {

    const [isAuthenticated, setAuthenticated] = useState(false);
    const [username, setUsername] = useState(null);
    const [token, setToken] = useState(null);

    // async function login(username, password) {
    //
    //     const basicToken = 'Basic ' + window.btoa(username + ":" + password);
    //
    //     try {
    //         const response
    //             = await executeBasicAuthenticationService(basicToken);
    //
    //         if (response.status === 200) {
    //             setAuthenticated(true);
    //             setUsername(username);
    //             setToken(basicToken);
    //
    //             apiClient.interceptors.request.use(
    //                 (config) => {
    //                     console.log(config);
    //                     config.headers.Authorization = basicToken;
    //                     return config;
    //                 }
    //             );
    //
    //             return true;
    //         } else {
    //             setAuthenticated(false);
    //             setUsername(null);
    //             setToken(null);
    //             return false;
    //         }
    //     } catch (error) {
    //         logout();
    //         return false;
    //     }
    // }

    async function login(username, password) {

        try {
            const response
                = await executeJwtAuthenticationService(username, password);

            if (response.status === 200) {
                const jwtToken = `Bearer ` + response.data.token;
                setAuthenticated(true);
                setUsername(username);
                setToken(jwtToken);

                apiClient.interceptors.request.use(
                    (config) => {
                        console.log(config);
                        config.headers.Authorization = jwtToken;
                        return config;
                    }
                );

                return true;
            } else {
                setAuthenticated(false);
                setUsername(null);
                setToken(null);
                return false;
            }
        } catch (error) {
            logout();
            return false;
        }
    }


    function logout() {
        setAuthenticated(false);
        setUsername(null);
        setToken(null);
    }

    return (
        <AuthContext.Provider value={{isAuthenticated, login, logout, username, token}}>
            {children}

        </AuthContext.Provider>
    )
}