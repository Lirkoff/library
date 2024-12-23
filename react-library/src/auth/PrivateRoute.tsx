import React, { ReactNode, useEffect } from "react";
import { Route, Redirect, useHistory } from "react-router-dom";
import {useAuth} from "./context/AuthContext";

interface PrivateRouteProps {
    children: ReactNode;
    path: string;
}

const PrivateRoute: React.FC<PrivateRouteProps> = ({ children, path, ...rest }) => {
    const { token, user } = useAuth();
    const history = useHistory();

    useEffect(() => {
        if (!token && !user) {
            history.push("/login"); // Redirect to login if not authenticated
        }

        if (path === '/admin' && !user?.roles.includes('ROLE_ADMIN' || 'ROLE_MODERATOR')) {
            history.push("/");
        }

    }, [token, user, history]);

    return (
        <Route
            {...rest}
            render={() => (token ? children : <Redirect to="/login" />)}
        />
    );
};

export default PrivateRoute;
