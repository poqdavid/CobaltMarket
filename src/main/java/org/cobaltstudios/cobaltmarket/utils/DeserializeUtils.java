package org.cobaltstudios.cobaltmarket.utils;

import org.cobaltstudios.cobaltmarket.CobaltMarket;
import org.spongepowered.api.item.inventory.Inventories;
import org.spongepowered.api.item.inventory.custom.CustomInventory;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by iTidez on 10/25/15.
 */
public class DeserializeUtils {
    public static List<String> list(String list) {

        List<String> result = new ArrayList<String>();
        if(list.equalsIgnoreCase("")) return result;

        for(String s : list.split(",")) result.add(s);
        return result;

    }

    public static List<String> messages(String messages) {

        List<String> result = new ArrayList<String>();
        if(messages.equalsIgnoreCase("")) return result;

        for(String s : messages.split("-;;")) result.add(s);
        return result;

    }

    public static CustomInventory inventory(String inventory) {
        CustomInventory result = Inventories.customInventoryBuilder()
                                    .size(5)
                                    .build();
        return result;
    }

    public static Location location(String loc) {
        Location result = null;

        if(loc.equalsIgnoreCase("")) return result;
        World world = null;
        int x = 0;
        int y = 0;
        int z = 0;
        int i = 0;

        for(String s : loc.split("-;;")) {
            switch(i) {
                case 0:
                    world = CobaltMarket.getInstance().getGame().getServer().getWorld(s).get();
                    break;
                case 1:
                    x = Integer.parseInt(s);
                    break;
                case 2:
                    y = Integer.parseInt(s);
                    break;
                case 3:
                    z = Integer.parseInt(s);
                    break;
                default:
                    break;
            }
            i++;
        }

        result = new Location(world, x, y, z);
        return result;
    }

    public static HashMap<String, Double> members(String members) {

        HashMap<String, Double> result = new HashMap<String, Double>();

        if(members.equalsIgnoreCase("")) return result;

        for(String s : members.split("-;;")) {
            String member = s.split(":")[0];
            double time = Double.parseDouble(s.split(":")[1]);
            result.put(member, time);
        }

        return result;

    }

    public static HashMap<String, String> settings(String settings) {

        HashMap<String, String> result = new HashMap<String, String>();

        if(settings.equalsIgnoreCase("")) return result;

        for(String s : settings.split("-;;")) {
            String setting = s.split(":")[0];
            String value = s.split(":")[1];
            result.put(setting, value);
        }

        return result;

    }
}
