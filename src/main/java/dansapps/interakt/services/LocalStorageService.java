/*
  Copyright (c) 2022 Daniel McCoy Stephenson
  Apache License 2.0
 */
package dansapps.interakt.services;

import dansapps.interakt.data.PersistentData;
import dansapps.interakt.factories.*;
import dansapps.interakt.objects.*;
import dansapps.interakt.utils.Logger;
import preponderous.ponder.misc.JsonWriterReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Daniel McCoy Stephenson
 * @since January 8th, 2022
 */
public class LocalStorageService {
    private static LocalStorageService instance;

    public final static String FILE_PATH = "/Interakt/";
    public final static String LOG_FILE_NAME = "log.txt";

    private final static String ACTORS_FILE_NAME = "actors.json";
    private final static String WORLDS_FILE_NAME = "worlds.json";
    private final static String REGIONS_FILE_NAME = "regions.json";
    private final static String SQUARES_FILE_NAME = "squares.json";
    private final static String TIME_PARTITIONS_FILE_NAME = "timePartitions.json";
    private final static String ACTION_RECORDS_FILE_NAME = "actionRecords.json";
    private final JsonWriterReader jsonWriterReader = new JsonWriterReader();

    private LocalStorageService() {
        jsonWriterReader.initialize(FILE_PATH);
    }

    public static LocalStorageService getInstance() {
        if (instance == null) {
            instance = new LocalStorageService();
        }
        return instance;
    }

    public void save() {
        try {
            saveActors();
            saveWorlds();
            saveRegions();
            saveSquares();
            saveTimePartitions();
            saveActionRecords();
        }
        catch(Exception e) {
            Logger.getInstance().logError("Something went wrong when saving the data of the application.");
        }
    }

    public void load() {
        try {
            loadActors();
            loadWorlds();
            loadRegions();
            loadSquares();
            loadTimePartitions();
            loadActionRecords();
        }
        catch(Exception e) {
            Logger.getInstance().logError("Something went wrong when loading the data of the application.");
        }
    }

    private void saveActors() {
        List<Map<String, String>> actors = new ArrayList<>();
        for (Actor actor : PersistentData.getInstance().getActors()){
            actors.add(actor.save());
        }
        jsonWriterReader.writeOutFiles(actors, ACTORS_FILE_NAME);
    }

    private void saveWorlds() {
        List<Map<String, String>> worlds = new ArrayList<>();
        for (World world : PersistentData.getInstance().getWorlds()){
            worlds.add(world.save());
        }
        jsonWriterReader.writeOutFiles(worlds, WORLDS_FILE_NAME);
    }

    private void saveRegions() {
        List<Map<String, String>> regions = new ArrayList<>();
        for (Region region : PersistentData.getInstance().getRegions()){
            regions.add(region.save());
        }
        jsonWriterReader.writeOutFiles(regions, REGIONS_FILE_NAME);
    }

    private void saveSquares() {
        List<Map<String, String>> squares = new ArrayList<>();
        for (Square square : PersistentData.getInstance().getSquares()){
            squares.add(square.save());
        }
        jsonWriterReader.writeOutFiles(squares, SQUARES_FILE_NAME);
    }

    private void saveTimePartitions() {
        List<Map<String, String>> timeSlots = new ArrayList<>();
        for (TimePartition timePartition : PersistentData.getInstance().getTimePartitions()){
            timeSlots.add(timePartition.save());
        }
        jsonWriterReader.writeOutFiles(timeSlots, TIME_PARTITIONS_FILE_NAME);
    }

    private void saveActionRecords() {
        List<Map<String, String>> actionRecords = new ArrayList<>();
        for (ActionRecord actionRecord : PersistentData.getInstance().getActionRecords()){
            actionRecords.add(actionRecord.save());
        }
        jsonWriterReader.writeOutFiles(actionRecords, ACTION_RECORDS_FILE_NAME);
    }

    private void loadActors() {
        PersistentData.getInstance().getActors().clear();
        ArrayList<HashMap<String, String>> data = jsonWriterReader.loadDataFromFilename(FILE_PATH + ACTORS_FILE_NAME);
        for (Map<String, String> actorData : data){
            ActorFactory.getInstance().createActor(actorData);
        }
    }

    private void loadWorlds() {
        PersistentData.getInstance().getWorlds().clear();
        ArrayList<HashMap<String, String>> data = jsonWriterReader.loadDataFromFilename(FILE_PATH + WORLDS_FILE_NAME);
        for (Map<String, String> worldData : data){
            WorldFactory.getInstance().createWorld(worldData);
        }
    }

    private void loadRegions() {
        PersistentData.getInstance().getRegions().clear();
        ArrayList<HashMap<String, String>> data = jsonWriterReader.loadDataFromFilename(FILE_PATH + REGIONS_FILE_NAME);
        for (Map<String, String> regionData : data){
            RegionFactory.getInstance().createRegion(regionData);
        }
    }

    private void loadSquares() {
        PersistentData.getInstance().getSquares().clear();
        ArrayList<HashMap<String, String>> data = jsonWriterReader.loadDataFromFilename(FILE_PATH + SQUARES_FILE_NAME);
        for (Map<String, String> squareData : data){
            SquareFactory.getInstance().createSquare(squareData);
        }
    }

    private void loadTimePartitions() {
        PersistentData.getInstance().getTimePartitions().clear();
        ArrayList<HashMap<String, String>> data = jsonWriterReader.loadDataFromFilename(FILE_PATH + TIME_PARTITIONS_FILE_NAME);
        for (Map<String, String> timePartitionData : data){
            TimePartitionFactory.getInstance().createTimePartition(timePartitionData);
        }
    }

    private void loadActionRecords() {
        PersistentData.getInstance().getActionRecords().clear();
        ArrayList<HashMap<String, String>> data = jsonWriterReader.loadDataFromFilename(FILE_PATH + ACTION_RECORDS_FILE_NAME);
        for (Map<String, String> actionRecordData : data){
            ActionRecordFactory.getInstance().createActionRecord(actionRecordData);
        }
    }
}