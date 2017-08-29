package rest;


public class ConfigurationDB {
    private static Map<Integer, Configuration> configurationDB = new ConcurrentHashMap<Integer, Configuration>();
    private static AtomicInteger idCounter = new AtomicInteger();

    public static void createConfiguration(String content, Status status){
        Configuration c = new Configuration();
        c.setId(idCounter.incrementAndGet());
        c.setContent(content);
        c.setStatus(status);
        configurationDB.put(c.getId(), c);
    }

    public static List<Configuration> getAllConfigurations(){
        return new ArrayList<Configuration>(configurationDB.values());
    }
}