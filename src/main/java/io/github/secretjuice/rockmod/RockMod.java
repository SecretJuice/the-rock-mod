package io.github.secretjuice.rockmod;

import com.google.gson.JsonObject;
import io.github.secretjuice.rockmod.core.dispenserbehaviors.RockDispenserBehavior;
import io.github.secretjuice.rockmod.core.init.BlockInit;
import io.github.secretjuice.rockmod.core.init.ItemInit;
import io.github.secretjuice.rockmod.core.maps.SmashableBlocks;
import io.github.secretjuice.rockmod.network.handler.RockModPacketHandler;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.Inverted;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

@Mod(RockMod.MOD_ID)
public class RockMod
{

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "sj_rock_mod";
    public static final ItemGroup ROCK_GROUP = new RockItemGroup("sj_rock_mod_tab");

    public RockMod() {

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        GLM.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }



    private static final DeferredRegister<GlobalLootModifierSerializer<?>> GLM = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, MOD_ID);

    private static final RegistryObject<StrangeDustLeavesModifier.Serializer> BREAK_LEAVES = GLM.register("break_leaves", StrangeDustLeavesModifier.Serializer::new);

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class DataGenerators {

        @SubscribeEvent
        public static void registerDataProviders(GatherDataEvent event){

            event.getGenerator().addProvider(new LootDataProvider(event.getGenerator(), MOD_ID));

        }
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        RockModPacketHandler.register();
        RockDispenserBehavior.init();
        SmashableBlocks.initializeHashMap();
    }



    public static class RockItemGroup extends ItemGroup {
        public RockItemGroup(String label) {
            super(label);
        }

        @Override
        public ItemStack createIcon(){
            return ItemInit.ROCK.get().getDefaultInstance();
        }


    }



    private static class LootDataProvider extends GlobalLootModifierProvider
    {
        public LootDataProvider(DataGenerator gen, String modid)
        {
            super(gen, modid);
        }

        @Override
        protected void start()
        {
            add("break_leaves", BREAK_LEAVES.get(), new StrangeDustLeavesModifier(
                    new ILootCondition[]{
                            MatchTool.builder(ItemPredicate.Builder.create().item(Items.STICK)).build(),
                            BlockStateProperty.builder(Blocks.OAK_LEAVES).build()
                    },
                    0.25F, 1, ItemInit.STRANGE_DUST.get()
            ));
        }
    }

    private static class StrangeDustLeavesModifier extends LootModifier{

        private final float dropChance;
        private final int dropNum;
        private final Item dropItem;

        public StrangeDustLeavesModifier(ILootCondition[] conditions, float dropChanceIn, int dropNumIn, Item dropItemIn) {
            super(conditions);
            dropChance = dropChanceIn;
            dropNum = dropNumIn;
            dropItem = dropItemIn;

        }

        @Nonnull
        @Override
        public List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context){

            Random rand = new Random();
            if(rand.nextFloat() < dropChance){
                generatedLoot.add(new ItemStack(dropItem, dropNum));
            }
            return generatedLoot;
        }

        private static class Serializer extends GlobalLootModifierSerializer<StrangeDustLeavesModifier> {

            @Override
            public StrangeDustLeavesModifier read(ResourceLocation name, JsonObject object, ILootCondition[] conditons) {
                float dataChance = JSONUtils.getFloat(object, "dropChance");
                int dataNum = JSONUtils.getInt(object, "dropNum");
                Item dataItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "drop")));
                return new StrangeDustLeavesModifier(conditons, dataChance, dataNum, dataItem);
            }
            @Override
            public JsonObject write(StrangeDustLeavesModifier instance){
                JsonObject json = makeConditions(instance.conditions);
                json.addProperty("dropChance", instance.dropChance);
                json.addProperty("dropNum", instance.dropNum);
                json.addProperty("drop", ItemInit.STRANGE_DUST.get().toString());
                return json;
            }
        }

    }

}
