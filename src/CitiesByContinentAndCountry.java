import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> continentMap = new LinkedHashMap<>();
        for (int i = 0; i < num; i++) {
            String[] input = scanner.nextLine().split("\\s++");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (continentMap.isEmpty()) {
                Map<String, List<String>> countryCity = new LinkedHashMap<>();
                List<String> citiesList = new ArrayList<>();
                citiesList.add(city);
                countryCity.put(country, citiesList);
                continentMap.put(continent, countryCity);
            } else {
                Map<String, List<String>> countryCity = new LinkedHashMap<>();
                String currentContinent;

                String currentCity;
                for (Map.Entry<String, Map<String, List<String>>> entry : continentMap.entrySet()) {
                    currentContinent = entry.getKey();
                }
                for (Map.Entry<String, Map<String, List<String>>> entry : continentMap.entrySet()) {

                }
                //countryCity.put(country)
            }
        }
        System.out.println();
    }
}
