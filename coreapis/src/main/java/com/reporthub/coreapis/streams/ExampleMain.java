package com.reporthub.coreapis.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reporthub.coreapis.records.OrgApiResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleMain {

    public static void main(String[] args) {


        /*
        long start = System.currentTimeMillis();
        IntStream.range(0, 100).forEach(System.out::println);
        long end = System.currentTimeMillis();

        System.out.println("Plain stream time taken: " + (end-start) );

        System.out.println("==================================================");
        start = System.currentTimeMillis();
        IntStream.range(0, 100).parallel().forEach(System.out::println);
        end = System.currentTimeMillis();

        System.out.println("parallel stream time taken: " + (end-start) );

        */

/*
        IntStream.range(0,10).forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + " : "+x);
        });


        IntStream.range(0,10).parallel().forEach(x -> {
            System.out.println("Thread : " + Thread.currentThread().getName() + " : "+x);
        });*/


        /*

        List<Employee> employeeList = EmployeeDatabase.getEmployeeList();

        long start = System.currentTimeMillis();
        double plainStreamResult = employeeList.stream().map(Employee::salary).mapToDouble(i -> i).average().getAsDouble();
        long end = System.currentTimeMillis();

        System.out.println("time took for plain stream: "+ (end-start) + " result : "+plainStreamResult);


        start = System.currentTimeMillis();
        double parallelStreamResult = employeeList.parallelStream().map(Employee::salary).mapToDouble(i -> i).average().getAsDouble();
        end = System.currentTimeMillis();

        System.out.println("time took for parallel stream: "+ (end-start) + " result : "+parallelStreamResult);

*/
   /*     int offset = 1;
        int LIMT = 25;
        for(int i=1; i<=1000; i++) {
            System.out.println(offset);
            offset += LIMT;
        }*/
//        System.out.println(extractMemberInfo("Kumar",null));

//        System.out.println(StargateEnv.CORE_STAGE.name());
//        System.out.println(StargateEnv.values());
//        System.out.println(StargateEnv.CORE_PROD.name());
//        Map<String,String> pesScrets = new HashMap<>();
//        pesScrets.put("PESMigrationClientNonProdSecret","RDB8Q~UqDvgDgYCwQLBBQCz8Kb3AQn6AS~yNycsh");
//        pesScrets.put("PESMigrationClientProdSecret", "4~18Q~MCOAoM9JvjGeDZuYQinWP8hbdsJYeSiaQa");
//
//        System.out.println(pesScrets.getOrDefault("PESMigrationClientNonProdSecret","O"));

//        String host = "gateway-stage-core.optum.com";
//        System.out.println(host.split("\\.")[0].replaceAll("gateway-","").toString());


//        String fileName = String.format("PCPPanelRoster_%s_%s%s","20230802125012","123261572",".xlsx");
//        System.out.println(fileName);

//        Product product = new Product("iphone",9.29,3,false);
//        System.out.println(product);

    /*    HashMap<String,Integer> rankMap = new HashMap<>();
        rankMap.put("ashwini",21);
        rankMap.put("kumar",5);
        rankMap.put("ram",21);
        rankMap.put("krishna",7);
        System.out.println(rankMap.entrySet().stream().filter(entry -> entry.getValue() ==21).collect(Collectors.toList()));*/

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor()

//         processJsonData() ;

          String startgateEnv = "gateway.optum.com";
          String splitString = startgateEnv.split("\\.")[0];
          System.out.println("output after spltt: "+splitString
                  .replaceAll("gateway-","")
                  .replaceAll("gateway",""));

          returnSomeResponse(List.of("Ash","AK"));
    }

    static int returnSomeResponse(List<String> processID, String... someIDs) {

        System.out.println(processID);
        List<String> someIdFilter = Arrays.asList(someIDs);
        if(!CollectionUtils.isEmpty(someIdFilter)) {
            System.out.println(someIdFilter);
        }

        return 0;
    }

    private static void processJsonData() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("org-apiresponse.json")) {
            OrgApiResponse response = mapper.readValue(in, OrgApiResponse.class);

            //System.out.println(response.demographics());
            //response.providerOrg().forEach(System.out::println);
            HashMap<String, OrgApiResponse.ProviderOrg> orgHashMap = new HashMap<>();

            List<String> resultStream = response.providerOrg().stream().map(orgUser ->
                                                                Stream.of(orgUser.firstName(), orgUser.lastName())
                                                                        .filter(StringUtils::hasText)
                                                                        .collect(Collectors.joining(",")))
                            .collect(Collectors.toList());


            System.out.println(resultStream);

        } catch (IOException ex) {
            System.out.println("exception occured "+ ex.getMessage());
        }




    }


    private static String extractMemberInfo(final String memberFirstName, final String memberLastName) {
        final String COMMA_SEPARATOR = ",";
        return Stream.of(memberLastName,memberFirstName)
                .filter(org.springframework.util.StringUtils::hasText).collect(Collectors.joining(COMMA_SEPARATOR));
    }
}
