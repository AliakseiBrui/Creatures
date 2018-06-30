package com.epam.creatures.entity;

import java.util.Objects;

public class Router {

    public enum RouteType{
        FORWARD,
        REDIRECT
    }

    private RouteType routeType;
    private String route;

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Router router = (Router) o;
        return routeType == router.routeType &&
                Objects.equals(route, router.route);
    }

    @Override
    public int hashCode() {

        return Objects.hash(routeType, route);
    }
}
