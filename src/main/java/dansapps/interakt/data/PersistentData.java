/*
  Copyright (c) 2022 Daniel McCoy Stephenson
  Apache License 2.0
 */
package dansapps.interakt.data;

import dansapps.interakt.objects.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

/**
 * @author Daniel McCoy Stephenson
 * @since January 7th, 2022
 */
public class PersistentData {
    private static PersistentData instance;
    private HashSet<Entity> entities = new HashSet<>();
    private HashSet<Environment> environments = new HashSet<>();
    private HashSet<Grid> grids = new HashSet<>();
    private HashSet<Location> locations = new HashSet<>();
    private ArrayList<TimeSlot> timeSlots = new ArrayList<>();

    private PersistentData() {

    }

    public static PersistentData getInstance() {
        if (instance == null) {
            instance = new PersistentData();
        }
        return instance;
    }

    public HashSet<Entity> getEntities() {
        return entities;
    }

    public void setEntities(HashSet<Entity> entities) {
        this.entities = entities;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public Entity getEntity(String name) throws Exception {
        for (Entity entity : entities) {
            if (entity.getName().equalsIgnoreCase(name)) {
                return entity;
            }
        }
        throw new Exception();
    }

    public Entity getEntity(UUID entityUUID) {
        for (Entity entity : entities) {
            if (entity.getUUID().equals(entityUUID)) {
                return entity;
            }
        }
        return null;
    }

    public HashSet<Environment> getEnvironments() {
        return environments;
    }

    public void setEnvironments(HashSet<Environment> environments) {
        this.environments = environments;
    }

    public void addEnvironment(Environment environment) {
        environments.add(environment);
    }

    public void removeEnvironment(Environment environment) {
        environments.remove(environment);
    }

    public Environment getEnvironment(String name) throws Exception {
        for (Environment environment : environments) {
            if (environment.getName().equalsIgnoreCase(name)) {
                return environment;
            }
        }
        throw new Exception();
    }

    public Environment getEnvironment(UUID environmentUUID) {
        for (Environment environment : environments) {
            if (environment.getUUID().equals(environmentUUID)) {
                return environment;
            }
        }
        return null;
    }

    public HashSet<Grid> getGrids() {
        return grids;
    }

    public void setGrids(HashSet<Grid> grids) {
        this.grids = grids;
    }

    public void addGrid(Grid grid) {

    }

    public HashSet<Location> getLocations() {
        return locations;
    }

    public void setLocations(HashSet<Location> locations) {
        this.locations = locations;
    }

    public void addLocation(Location gridLocation) {

    }

    public ArrayList<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(ArrayList<TimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public void addTimeSlot(TimeSlot timeSlot) {
        timeSlots.add(timeSlot);
    }

    public void removeTimeSlot(TimeSlot timeSlot) {
        timeSlots.remove(timeSlot);
    }

    public void clearData() {
        entities.clear();
        environments.clear();
        grids.clear();
        locations.clear();
        timeSlots.clear();
    }
}