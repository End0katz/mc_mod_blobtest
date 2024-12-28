package com.end0katz.blobtest;

import net.minecraft.component.ComponentType;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

public class ModItems {

    public static class ModItem {
        public Item.Settings SETTINGS;
        //public Item ITEM = new Item(SETTINGS);
        public String ID;

        public ModItem (String id){
            this.ID = id;
            this.SETTINGS = new Item.Settings();
        }

        public ModItem (String id, Item.Settings settings){
            this.ID = id;
            this.SETTINGS = settings.registryKey(
                    RegistryKey.of(
                            RegistryKeys.ITEM,
                            Identifier.of(Blobtest.MOD_ID, this.ID)
                    )
            );
        }

        public ModItem fireproof(){
            this.SETTINGS.fireproof();
            return this;
        }

        public <T> ModItem component(ComponentType<T> component, T value){
            this.SETTINGS.component(component, value);
            return this;
        }

        public ModItem enchantability(int equals){
            this.SETTINGS.enchantable(equals);
            return this;
        }

        public ModItem attributeModifiyers(AttributeModifiersComponent... x){
            for (AttributeModifiersComponent i : x){
                this.SETTINGS.attributeModifiers(i);
            }
            return this;
        }

        public ModItem equippable(EquipmentSlot slot){
            SETTINGS.equippable(slot);
            return this;
        }

        public ModItem equippable(EquipmentSlot slot, boolean unswappable){
            if (unswappable) {SETTINGS.equippableUnswappable(slot);} else {this.equippable(slot);}
            return this;
        }

        //public ModItem(){
        //    ModItems.items.add(this);
        //}
    }


    private static int ItemsToRegister = 0;
    private static int ItemsRegistered = 0;


    public static final Item BLOBIUM_INGOT = register(new ModItem("blobium_ingot").fireproof());
    public static final Item BLOBIUM_NUGGET = register(new ModItem("blobium_nugget").fireproof());

    private static Item register(ModItem item){
        ItemsToRegister++;
        while (!Blobtest.initstate.equals(Blobtest.InitState.ITEMS)) {
            pass();
        }
        Item result = Items.register(
                RegistryKey.of(
                        RegistryKeys.ITEM,
                        Identifier.of(Blobtest.MOD_ID, item.ID)
                ),
                Item::new,
                item.SETTINGS.registryKey(
                        RegistryKey.of(
                                RegistryKeys.ITEM,
                                Identifier.of(Blobtest.MOD_ID, item.ID)
                        ))
        );
        Blobtest.completed("Item: %s".formatted(item.ID));
        ItemsRegistered++;
        return result;
    }

    public static void pass() {}

    public static void initialize() {
        do {pass();} while (ItemsToRegister != ItemsRegistered);
    }


}
