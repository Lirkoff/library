import React, { ReactNode, useEffect } from "react";
import { Route, Redirect, useHistory } from "react-router-dom";
import {useAuth} from "./context/AuthContext";

interface PrivateRouteProps {
    children: ReactNode;
    path: string;
}

const PrivateRoute: React.FC<PrivateRouteProps> = ({ children, path, ...rest }) => {
    const { token } = useAuth();
    const history = useHistory();

    useEffect(() => {
        if (!token) {
            history.push("/login"); // Redirect to login if not authenticated
        }
    }, [token, history]);

    return (
        <Route
            {...rest}
            render={() => (token ? children : <Redirect to="/login" />)}
        />
    );
};

export default PrivateRoute;
