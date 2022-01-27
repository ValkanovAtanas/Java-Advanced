package sets_and_maps_advanced;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> continentMap = new LinkedHashMap<>();
        int numOfLines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfLines; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            continentMap = processTheMap(continentMap, input);
        }
        printTheMap(continentMap);
    }

    private static void printTheMap(Map<String, Map<String, List<String>>> continentMap) {
        int numOfContinents = continentMap.size();
        for (Map.Entry<String, Map<String, List<String>>> entry : continentMap.entrySet()) {
            String currentContinent = entry.getKey();
            System.out.printf("%s:%n", currentContinent);
            Map<String, List<String>> countryAndCitiesMap = new LinkedHashMap<>();
            countryAndCitiesMap = entry.getValue();
            for (Map.Entry<String, List<String>> secEntry : countryAndCitiesMap.entrySet()){
                {
                    String currentCountry = secEntry.getKey();
                    System.out.printf(" %s -> ", currentCountry);
                    List<String> citiesList = new ArrayList<>();
                    citiesList = secEntry.getValue();
                    String citiesListToPrint = citiesList.toString();
                    citiesListToPrint = citiesListToPrint.replaceAll("\\[|\\]", "");
                    System.out.println(citiesListToPrint);
                }
            }

        }
    }

    private static Map<String, Map<String, List<String>>> processTheMap(Map<String, Map<String, List<String>>> continentMap, String[] input) {
        String continentFromInput = input[0];
        String countryFromInput = input[1];
        String cityFromInput = input[2];
        Map<String, List<String>> countryAndCitiesMap = new LinkedHashMap<>();

        if (!continentMap.containsKey(continentFromInput)) {
            List<String> citiesList = new ArrayList<>();
            citiesList.add(cityFromInput);
            countryAndCitiesMap.put(countryFromInput, citiesList);
            continentMap.put(continentFromInput, countryAndCitiesMap);
        } else {
            countryAndCitiesMap = continentMap.get(continentFromInput);
            List<String> citiesList = new ArrayList<>();
            if (!countryAndCitiesMap.containsKey(countryFromInput)) {
                citiesList.add(cityFromInput);
                countryAndCitiesMap.put(countryFromInput, citiesList);
                continentMap.put(continentFromInput, countryAndCitiesMap);
            } else {
                citiesList = countryAndCitiesMap.get(countryFromInput);
                citiesList.add(cityFromInput);
                countryAndCitiesMap.put(countryFromInput, citiesList);
                continentMap.put(continentFromInput, countryAndCitiesMap);
            }
        }
        return continentMap;
    }
}
