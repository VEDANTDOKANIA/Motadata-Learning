package org.example.ProcessBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProcessBuilderPractical {

    /*
    This method will ask user to enter IP address and then execute fping command using process
    builder object.
    1. Ask user IP address
    2. validate IP address
    3. Create Process Builder using fping
    4. Store result inside bufferedReader object
    5. Store result inside Linkedlist object
     */
    private void getUserInputAndCalculateOutput() throws IOException {
        BufferedReader fpingBufferedReader = null;

        Process process = null;

        try {

            var userInputBufferedReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter an IP Address");

            var sb = new StringBuilder();

            sb.append(userInputBufferedReader.readLine());

            if (sb.isEmpty()) {
                // userInputBufferedReader is empty
                System.out.println("IP address not stored properly");
            } else {
                var ipList = Arrays.stream(sb.toString().split(",")).toList();

                process = new ProcessBuilder("fping", sb.toString()).start();

                fpingBufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

//                StringBuilder result = new StringBuilder();

//                for (String temResult; (temResult = fpingBufferedReader.readLine()) != null; ) {
//
//                    result.append(temResult).append("\n");
//
//                }

                var result = new StringBuilder(fpingBufferedReader.readLine());

                if (result.toString().contains("alive")) {

                    // device is discoverable

                    System.out.println("It is reachable");

                } else {

                    // device is unreachable

                    System.out.println("It is not reachable");

                }

//                System.out.println("Result: "+result);
            }
        } catch (Exception exception) {

            exception.printStackTrace();

        } finally {

            if (fpingBufferedReader != null) {

                fpingBufferedReader.close();

            }

            if (process != null) {

                process.destroy();

            }
        }

    }
    public static void main(String[] args) throws IOException {
//        Process process = new ProcessBuilder("ping", "-c 3", "google.com").start();
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//
//        StringBuilder sb = new StringBuilder();
//        String tem;
//        while ((tem = bufferedReader.readLine()) != null) {
//            sb.append(tem);
//            sb.append("\n");
//        }
//
//        System.out.println(sb);

        ProcessBuilderPractical processBuilderPractical = new ProcessBuilderPractical();
        processBuilderPractical.getUserInputAndCalculateOutput();
    }
}
