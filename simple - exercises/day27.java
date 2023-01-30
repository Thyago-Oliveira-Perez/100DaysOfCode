import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class day27 {

    public static void main(String[] args) {

        System.out.println(MessageFormat.format("{0}", TaskScheduler(new char[]{'A','A','A','B','B','B'},2)));
        System.out.println(MessageFormat.format("{0}", TaskScheduler(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2)));
    }

    public static int TaskScheduler (char[] tasks, int interval) {

        if (interval == 0)  return tasks.length;
        if (tasks.length < 1 || tasks.length > 104) return 0;
        if (!(0 <= interval && interval <= 100)) return 0;

        List<Task> tasksAndFrequencies = GetFrequency(tasks);

        int maximumRows = 0;
        int lastRowLength = 0;

        for (Task tasksAndFrequency : tasksAndFrequencies) {

            if (tasksAndFrequency.frequency > maximumRows) {
                maximumRows = tasksAndFrequency.frequency;
            }

            if (maximumRows == tasksAndFrequency.frequency) {
                lastRowLength++;
            }

        }


        return (maximumRows - 1) * (interval + 1) + lastRowLength;
    }

    public static List<Task> GetFrequency (char[] tasks) {

        List<Task> taskList = new ArrayList<>();

        for (char c : tasks) {

            String taskString = String.valueOf(c);
            Task task = new Task();

            if (taskList.stream().noneMatch(e -> e.name.equals(taskString))) {
                task.name = taskString;
                task.frequency = 1;
                taskList.add(task);
            } else {
                taskList.forEach(e -> {
                    if (e.name.equals(taskString)) {
                        e.frequency += 1;
                    }
                });
            }
        }

        return taskList;
    }

    public static class Task {

        String name;
        int frequency;

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", frequency=" + frequency +
                    '}';
        }
    }
}
