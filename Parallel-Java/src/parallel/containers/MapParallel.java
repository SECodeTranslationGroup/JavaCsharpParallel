package parallel.containers;

import java.util.*;

public class MapParallel {
    public TreeMap<String,Object> postSendAllNews(String accessToken,boolean is_to_all,int groupId,String mediaId){
        TreeMap<String,Object> obj = new TreeMap<String,Object>();
        TreeMap<String,Object> params = new TreeMap<String,Object>();
        params.put("is_to_all",is_to_all);
        params.put("group_id",groupId);
        obj.put("filter", params);
        //
        TreeMap<String,Object> newsParasm = new TreeMap<String,Object>();
        newsParasm.put("media_id",mediaId);
        obj.put("mpnews", newsParasm);
        obj.put("msgtype", "mpnews");
        //
        return obj;
    }

    public TreeMap<String,Object> postSendAllVoice(String accessToken,boolean is_to_all,int groupId,String mediaId){
        TreeMap<String,Object> obj = new TreeMap<String,Object>();
        TreeMap<String,Object> params = new TreeMap<String,Object>();
        params.put("is_to_all",is_to_all);
        params.put("group_id",groupId);
        obj.put("filter", params);
        //
        TreeMap<String,Object> newsParasm = new TreeMap<String,Object>();
        newsParasm.put("media_id",mediaId);
        obj.put("voice", newsParasm);
        obj.put("msgtype", "voice");
        //
        return obj;
    }

    public TreeMap<String,Object> postSendAllImage(String accessToken,boolean is_to_all,int groupId,String mediaId){
        TreeMap<String,Object> obj = new TreeMap<String,Object>();
        TreeMap<String,Object> params = new TreeMap<String,Object>();
        params.put("is_to_all",is_to_all);
        params.put("group_id",groupId);
        obj.put("filter", params);
        //
        TreeMap<String,Object> newsParasm = new TreeMap<String,Object>();
        newsParasm.put("media_id",mediaId);
        obj.put("image", newsParasm);
        obj.put("msgtype", "image");
        //

        return obj;
    }


    public void  removeAllMappingsFromTreeMap() {
        TreeMap<String, String> treemap = new TreeMap<String, String>();

        treemap.put("key1", "Jack");
        treemap.put("key2", "Rick");
        treemap.put("key3", "Kate");
        treemap.put("key4", "Tom");
        treemap.put("key5", "Steve");
        treemap.put("key6", "Ram");

        System.out.println("Before: TreeMap contains: " + treemap);
        treemap.clear();
        System.out.println("After: TreeMap contains: " + treemap);
    }

    public Map<String, String> toTransMap(Integer uuid, String repoName, String dirName){
        Map<String, String> arguments = new HashMap<>();

        arguments.putIfAbsent(  "uuid", uuid.toString() );
        arguments.putIfAbsent(  "repo", repoName );
        arguments.putIfAbsent(  "dir", dirName );
        return arguments;
    }

    public ArrayList<Character> ChefAndPickDigit(String a){
        ArrayList<Character> c = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        while (i < a.length()) {
            char d = a.charAt(i);
            if (map.containsKey(d)) {
                map.put(d, map.get(d) + 1);
            } else {
                map.put(d, 1);
            }
            i++;
        }
        //  out.println("iterated");
        if (map.containsKey('6') && map.containsKey('5')) {
            c.add('A');
        }
        if (map.containsKey('6') && map.get('6') >= 2) {
            c.add('B');
        }
        return c;
    }

    public List<Integer> ChefAndPickDigitList(List<Integer> a){
        List<Integer> c = new ArrayList<>();
        HashMap<Integer, Character> map = new HashMap<>();
        int i = 0;
        while (i < a.size()) {
            int d = a.get(i);
            if (map.containsKey(d)) {
                c.add(i);
            }
            i++;
        }
        return c;
    }

    public int mapProcessInt(HashMap<String, Integer> map)
    {
        String a = "value1";
        String b = "value2";

        int value1 = map.getOrDefault(a, 0);
        int value2 = map.getOrDefault(b, 0);

        return value1 + value2;
    }

    public String mapProcessString(HashMap<String, String> map)
    {
        String a = "value1";
        String b = "value2";

        String value1 = map.getOrDefault(a, "");
        String value2 = map.getOrDefault(b, "0");

        return value1 + value2;
    }

    public double mapProcessDouble(HashMap<String, Double> map)
    {
        String a = "value1";
        String b = "value2";

        double value1 = map.getOrDefault(a, 0.0);
        double value2 = map.getOrDefault(b, 0.0);

        return value1 + value2;
    }

    public boolean mapProcessBool(HashMap<String, Boolean> map)
    {
        String a = "value1";
        String b = "value2";

        boolean value1 = map.getOrDefault(a, false);
        boolean value2 = map.getOrDefault(b, false);

        return value1 && value2;
    }

    public List<Object> infoExtractUid(List<HashMap<String, Object>> users, HashMap<String, Object> uidMap){
        List<Object> infos = new ArrayList<>();
        for (HashMap<String, Object> user : users) {
            String uid = String.valueOf(user.get("screen_name"));
            if (!uidMap.containsKey(uid)) {
                infos.add(uid);
            }
        }
        return infos;
    }

    public List<Object> infoExtractName(List<HashMap<String, Object>> users, HashMap<String, Object> uidMap){
        List<Object> infos = new ArrayList<>();
        for (HashMap<String, Object> user : users) {
            String uid = String.valueOf(user.get("screen_name"));
            if (!uidMap.containsKey(uid)) {
                String name = String.valueOf(user.get("name"));
                infos.add(name);
            }
        }
        return infos;
    }

    public List<Object> infoExtractDescription(List<HashMap<String, Object>> users, HashMap<String, Object> uidMap){
        List<Object> infos = new ArrayList<>();
        for (HashMap<String, Object> user : users) {
            String uid = String.valueOf(user.get("screen_name"));
            if (!uidMap.containsKey(uid)) {
                String description = String.valueOf(user.get("description"));
                infos.add(description);
            }
        }
        return infos;
    }

    public List<Object> infoExtractIcon(List<HashMap<String, Object>> users, HashMap<String, Object> uidMap){
        List<Object> infos = new ArrayList<>();
        for (HashMap<String, Object> user : users) {
            String uid = String.valueOf(user.get("screen_name"));
            if (!uidMap.containsKey(uid)) {
                String icon = String.valueOf(user.get("profile_image_url"));
                infos.add(icon);
            }
        }
        return infos;
    }

    public List<Object> infoExtractUidWithFlag(List<HashMap<String, Object>> users, HashMap<String, Object> uidMap){
        List<Object> infos = new ArrayList<>();
        for (HashMap<String, Object> user : users) {
            String uid = String.valueOf(user.get("screen_name"));
            if (!uidMap.containsKey(uid)) {
                uidMap.put(uid, true);
                infos.add(uid);
            }
        }
        return infos;
    }

    public List<Object> infoExtractNameWithFlag(List<HashMap<String, Object>> users, HashMap<String, Object> uidMap){
        List<Object> infos = new ArrayList<>();
        for (HashMap<String, Object> user : users) {
            String uid = String.valueOf(user.get("screen_name"));
            if (!uidMap.containsKey(uid)) {
                String name = String.valueOf(user.get("name"));
                uidMap.put(uid, true);
                infos.add(name);
            }
        }
        return infos;
    }

    public List<Object> infoExtractDescriptionWithFlag(List<HashMap<String, Object>> users, HashMap<String, Object> uidMap){
        List<Object> infos = new ArrayList<>();
        for (HashMap<String, Object> user : users) {
            String uid = String.valueOf(user.get("screen_name"));
            if (!uidMap.containsKey(uid)) {
                String description = String.valueOf(user.get("description"));
                uidMap.put(uid, true);
                infos.add(description);
            }
        }
        return infos;
    }

    public List<Object> infoExtractIconWithFlag(List<HashMap<String, Object>> users, HashMap<String, Object> uidMap){
        List<Object> infos = new ArrayList<>();
        for (HashMap<String, Object> user : users) {
            String uid = String.valueOf(user.get("screen_name"));
            if (!uidMap.containsKey(uid)) {
                String icon = String.valueOf(user.get("profile_image_url"));
                uidMap.put(uid, true);
                infos.add(icon);
            }
        }
        return infos;
    }

}

