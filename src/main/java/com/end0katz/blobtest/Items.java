package com.end0katz.blobtest;

import com.end0katz.blobtest.items.*;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Items {

    private static int ItemsToRegister = 0;
    private static int ItemsRegistered = 0;


    public static final Item BLOBIUM_INGOT = register(new BLOBIUM_INGOT());
    public static final Item BLOBIUM_NUGGET = register(new BLOBIUM_NUGGET());

    private static Item register(ModItem item){
        ItemsToRegister++;
        while (!Blobtest.initstate.equals(Blobtest.InitState.ITEMS)) {
            pass();
        }
        Item result = Registry.register(
                Registries.ITEM,
                RegistryKey.of(
                        RegistryKeys.ITEM,
                        Identifier.of(Blobtest.MOD_ID, item.ID)
                ),
                item.ITEM
        );
        Blobtest.completed("Item: %s".formatted(item.ID));
        ItemsRegistered++;
        return result;
    }

    public static void pass() {}

    public static void initialize() {
        Blobtest.LOGGER.info("Items: Start");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Blobtest.LOGGER.info("Items: End");
    }


}
