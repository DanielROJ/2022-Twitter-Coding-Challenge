import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TetCase {

    /**
     * This exercise cost me 40.000usd,I have not passed because At that moment I was nervous but this is the solution, Time to resolve 45 min
     * https://github.com/5j54d93/2022-Twitter-Coding-Challenge/tree/main/1.%20Sign-in%20Sign-out%20Logs
     *
     * @param logs
     * @param maxSpan
     * @return
     */
    public static List<String> ExtractLogs(List<String> logs, int maxSpan) {
        List<Integer> result = new ArrayList<>();
        Map<String, Long> organizer = new HashMap<>();
        for (String log : logs) {
            String[] splitLog = log.split(" ");
            String idUser = splitLog[0];
            long timeStamp = Long.parseLong(splitLog[1]);
            String typeAction = splitLog[2];

            if (typeAction.equals("sign-in")) {
                organizer.put(idUser, timeStamp);
            } else if (typeAction.equals("sign-out") && organizer.containsKey(idUser)) {
                long timeSignIn = organizer.get(idUser);
                long total = timeStamp - timeSignIn;
                if (total <= maxSpan) {
                    result.add(Integer.parseInt(idUser));
                }
            }

        }

        Collections.sort(result);

        return result.stream().map(Object::toString)
                .collect(Collectors.toList());


    }

    public static void main(String[] args) {
        List<String> inputArray = Stream.of("30 99 sign-in", "30 105 sign-out", "12 100 sign-in", "20 80 sign-in", "12 120 sign-out", "20 101 sign-out", "21 110 sign-in").collect(Collectors.toList());
        List<String> result = ExtractLogs(inputArray, 20);
        for (String idUser :
                result) {
            System.out.println(idUser);
        }
    }
}
