import java.util.HashMap;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map. This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints." In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState {
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;

    private HashMap<Location, Waypoint> openedWaypoint;
    private HashMap<Location, Waypoint> closedWaypoint;

    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map) {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        closedWaypoint = new HashMap<Location, Waypoint>();
        openedWaypoint = new HashMap<Location, Waypoint>();
        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap() {
        return map;
    }

    /**
     * This method scans through all open waypoints, and returns the waypoint
     * with the minimum total cost. If there are no open waypoints, this method
     * returns <code>null</code>.
     **/
    public Waypoint getMinOpenWaypoint() {
        var mincost = Float.MAX_VALUE;
        Waypoint minWaypoint = null;
        for (var wpmin : openedWaypoint.entrySet()) {
            var cost = wpmin.getValue().getTotalCost();
            if (cost <= mincost) {
                mincost = cost;
                minWaypoint = wpmin.getValue();
            }

        }
        return minWaypoint;
    }

    /**
     * This method adds a waypoint to (or potentially updates a waypoint already
     * in) the "open waypoints" collection. If there is not already an open
     * waypoint at the new waypoint's location then the new waypoint is simply
     * added to the collection. However, if there is already a waypoint at the
     * new waypoint's location, the new waypoint replaces the old one <em>only
     * if</em> the new waypoint's "previous cost" value is less than the current
     * waypoint's "previous cost" value.
     **/
    public boolean addOpenWaypoint(Waypoint newWP) {
        if (!openedWaypoint.containsKey(newWP.getLocation()) || getCost(openedWaypoint.get(newWP.getLocation())) > getCost(newWP)) {
            openedWaypoint.put(newWP.getLocation(), newWP);
            return true;
        }
        return false;
    }

    // Вспомогательный метод 
    private float getCost(Waypoint newWP) {
        if (newWP == null)
            return 0;
        return newWP.getPreviousCost() + getCost(newWP.getPrevious());
    }

    /** Returns the current number of open waypoints. **/
    public int numOpenWaypoints() {
        return openedWaypoint.size();
    }

    /**
     * This method moves the waypoint at the specified location from the
     * open list to the closed list.
     **/
    public void closeWaypoint(Location loc) {
        closedWaypoint.put(loc, this.openedWaypoint.remove(loc));
    }

    /**
     * Returns true if the collection of closed waypoints contains a waypoint
     * for the specified location.
     **/
    public boolean isLocationClosed(Location loc) {
        return closedWaypoint.containsKey(loc);
    }
}
