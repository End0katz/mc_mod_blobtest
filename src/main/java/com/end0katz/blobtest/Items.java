package com.end0katz.blobtest;

import com.end0katz.blobtest.items.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Items {

    private static int registeredblocks = 0;
    private static int completedblocks = 0;


    public static final Item BLOBIUM_INGOT = register(new BLOBIUM_INGOT());
    public static final Item BLOBIUM_NUGGET = register(new BLOBIUM_NUGGET());

    private static Item register(ModItem item){
        registeredblocks++;
        while (!Blobtest.initstate.equals(Blobtest.InitState.ITEMS)) {}
        Item result = Registry.register(Registries.ITEM, Identifier.of(Blobtest.MOD_ID, item.ID), item.ITEM);
        Blobtest.completed("Item: %s".formatted(item.ID));
        completedblocks++;
        return result;
    }

    public static void initialize(){
        while (completedblocks == registeredblocks) {};
    }


}
