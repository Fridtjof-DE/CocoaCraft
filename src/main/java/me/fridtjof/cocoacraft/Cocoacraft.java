package me.fridtjof.cocoacraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Cocoacraft implements ModInitializer {

    public static final ItemGroup COCOACRAFT_GROUP = FabricItemGroupBuilder.create(
                    new Identifier("cocoacraft", "cocoacraft_group"))
            .icon(() -> new ItemStack(Cocoacraft.CHOCOLATE_DRINK))
            .build();

    public static final Item COCOA_POWDER = new Item(new FabricItemSettings().group(Cocoacraft.COCOACRAFT_GROUP));

    public static final FoodComponent CHOCOLATE_DRINK_FOOD = new FoodComponent.Builder().hunger(4).saturationModifier(0.3f).build();
    public static final FoodComponent HOT_CHOCOLATE_DRINK_FOOD = new FoodComponent.Builder().hunger(8).saturationModifier(0.6f).build();

    public static final Item CHOCOLATE_DRINK = new HoneyBottleItem(new FabricItemSettings().group(Cocoacraft.COCOACRAFT_GROUP).food(CHOCOLATE_DRINK_FOOD).recipeRemainder(Items.GLASS_BOTTLE).maxCount(16));
    public static final Item HOT_CHOCOLATE_DRINK = new HoneyBottleItem(new FabricItemSettings().group(Cocoacraft.COCOACRAFT_GROUP).food(HOT_CHOCOLATE_DRINK_FOOD).recipeRemainder(Items.GLASS_BOTTLE).maxCount(16));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("cocoacraft", "cocoa_powder"), COCOA_POWDER);
        Registry.register(Registry.ITEM, new Identifier("cocoacraft", "chocolate_drink"), CHOCOLATE_DRINK);
        Registry.register(Registry.ITEM, new Identifier("cocoacraft", "hot_chocolate_drink"), HOT_CHOCOLATE_DRINK);

    }

    //public static final Item HONEY_BOTTLE = Items.register("honey_bottle", (Item)new HoneyBottleItem(new Item.Settings().recipeRemainder(GLASS_BOTTLE).food(FoodComponents.HONEY_BOTTLE).group(ItemGroup.FOOD).maxCount(16)));

}
