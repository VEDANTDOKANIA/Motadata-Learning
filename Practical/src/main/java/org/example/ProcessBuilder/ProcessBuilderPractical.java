package org.example.ProcessBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//SLF4J LOGGING ... 
//Logger Object 
//Function start in case of error , proper logging 
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
    //GetPingResponse
    private boolean getUserInputAndCalculateOutput(StringBuilder ipInputStringBuilder) throws IOException {
        
        //reader
        BufferedReader fpingErrorBufferedReader = null;

        Process process = null;

        // constant .. HypenSeparator "-" NewLineSeparator -"/n"
        try {

            
            var ipList = Arrays.stream(ipInputStringBuilder.toString().split(",")).toList();

            //Why only 3 packets , not 2 not 4 // regex match group 
            process = new ProcessBuilder("fping", "-q", "-c 3", ipInputStringBuilder.toString()).start();

            fpingErrorBufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            var result = new StringBuilder(fpingErrorBufferedReader.readLine())
                    .toString()
                    .split(":")[1]
                    .trim();

            return result.charAt(16) == result.charAt(18) && result.charAt(20) == '0';

//                System.out.println("Result: "+result);
        } catch (Exception exception) {

            //define limit in length of stack trace
            exception.printStackTrace();

        } finally {

            if (fpingErrorBufferedReader != null) {

                fpingErrorBufferedReader.close();

            }

            if (process != null) {

                process.destroy();

            }

        }

        return false;

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

        //reader
        var userInputBufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter an IP Address");

        //builder
        var ipInputStringBuilder = new StringBuilder();

        //Is valid IP CHeck is remaining
        ipInputStringBuilder.append(userInputBufferedReader.readLine());

        if (ipInputStringBuilder.isEmpty()) {

            // userInputBufferedReader is empty
            System.out.println("IP address not stored properly");

            return;
        }

        ProcessBuilderPractical processBuilderPractical = new ProcessBuilderPractical();

        if (processBuilderPractical.getUserInputAndCalculateOutput(ipInputStringBuilder)) {

            System.out.println(ipInputStringBuilder + " -> It is reachable");

        } else {

            System.out.println(ipInputStringBuilder + " -> It is not reachable");

        }
    }
}
