package com.epam.creatures.entity;

import java.util.Objects;

/**
 * The type Router.
 */
public class Router implements Entity {

    /**
     * The enum Route type.
     */
    public enum RouteType{
        /**
         * Forward route type.
         */
        FORWARD,
        /**
         * Redirect route type.
         */
        REDIRECT
    }

    private RouteType routeType;
    private String route;

    /**
     * Instantiates a new Router.
     *
     * @param routeType the route type
     * @param route     the route
     */
    public Router(RouteType routeType, String route) {
        this.routeType = routeType;
        this.route = route;
    }

    /**
     * Gets route type.
     *
     * @return the route type
     */
    public RouteType getRouteType() {
        return routeType;
    }

    /**
     * Sets route type.
     *
     * @param routeType the route type
     */
    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    /**
     * Gets route.
     *
     * @return the route
     */
    public String getRoute() {
        return route;
    }

    /**
     * Sets route.
     *
     * @param route the route
     */
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

    @Override
    public String toString() {
        return "Router{" +
                "routeType=" + routeType +
                ", route='" + route + '\'' +
                '}';
    }
}
