//package ua.lviv.iot.spring.rest.Readers;
//
//import jakarta.persistence.criteria.CriteriaBuilder;
//import ua.lviv.iot.spring.rest.model.Client;
//import ua.lviv.iot.spring.rest.model.SolarPanel;
//import ua.lviv.iot.spring.rest.model.SolarStation;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class ClientReader {
//    public static String path = "/Users/macbook/Desktop/API/rest/filesCSV";
//
//    public static Map<Integer, Client> makeActionsOnFile(){
//        Map<Integer, Client> clientMap = new HashMap<>();
//        try(Scanner scanner = new Scanner(path)){
//            if (scanner.hasNextLine()) {
//                scanner.nextLine();
//            }
//
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] values = line.split(",");
//                if (values.length >= 4) {
//                    Integer id = Integer.parseInt(values[0].trim());
//                    String name = values[1].trim();
//                    String surname = values[2].trim();
//
//                    Client client = new Client(id, name, surname, new HashMap<>());
//
//
//                    int stationStartIndex = 4;
//                    while (stationStartIndex + 4 < values.length) {
//                        Integer idStation = Integer.parseInt(values[stationStartIndex].trim());
//                        double power = Double.parseDouble(values[stationStartIndex + 1].trim());
//                        String address = values[stationStartIndex + 2].trim();
//                        int panelId = Integer.parseInt(values[stationStartIndex + 3].trim());
//                        String type = values[4].trim();
//                        double panelPower = Double.parseDouble(values[stationStartIndex + 5].trim());
//                        double batteryCapacity = Double.parseDouble(values[stationStartIndex + 6].trim());
//                        double timeOfBatteryUsage = Double.parseDouble(values[stationStartIndex + 7].trim());
//                        double timeOfPanelUsage = Double.parseDouble(values[stationStartIndex + 8].trim());
//
//                        SolarPanel panel = new SolarPanel(id, type, panelPower, batteryCapacity, timeOfBatteryUsage, timeOfPanelUsage);
//                        SolarStation station = new SolarStation(idStation, panelId, power, address, new HashMap<>());
//
//                        client.addStation(idStation, station);
//                        client.addPanelToStation(idStation, panelId, panel);
//
//                        stationStartIndex += 8;
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Cannot find files");
//        }
//        return clientMap;
//    }
//}
