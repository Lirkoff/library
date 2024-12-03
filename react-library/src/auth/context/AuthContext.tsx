import React, { createContext, useState, useContext } from "react";
import {jwtDecode} from "jwt-decode";
import {useHistory} from "react-router-dom";

interface User {
    username: string;
    roles: string[];
}


interface AuthContextType {
    token: string | null;
    user: User | null;
    login: (token: string) => void;
    logout: () => void;
}

const AuthContext = createContext<AuthContextType | null>(null);

export const AuthProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
    const [token, setToken] = useState<string | null>(localStorage.getItem("token"));
    const [user, setUser] = useState<User | null>(null);
    const history = useHistory();

    const login = (token: string) => {
        setToken(token);
        localStorage.setItem("token", token);


        const payload = JSON.parse(atob(token.split(".")[1]));
        setUser({ username: payload.sub, roles: payload.roles });

    };

    const logout = () => {
        setToken(null);
        setUser(null);
        history.push("/");
        localStorage.removeItem("token");
    };

    return (
        <AuthContext.Provider value={{ token, login, logout, user }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => {
    const context = useContext(AuthContext);
    if (!context) throw new Error("useAuth must be used within an AuthProvider");
    return context;
};
