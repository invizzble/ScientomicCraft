package com.invizzble.SC.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.invizzble.SC.block.ModBlocks;
import com.invizzble.SC.block.SCBlock;

import cpw.mods.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
			
			break;
		case 0:
			generateOverworld(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			
			break;
		}
	}
	
	private void generateOverworld(World world, Random random, int chunkX, int chunkZ){
		generateOre(world, random, chunkX, chunkZ, ModBlocks.oreCopper, 50, 60, 8);
	}
	
	private void generateOre(World world, Random random, int chunkX, int chunkZ, SCBlock block, int chance, int maxY, int blocksPerVein){
		for(int k = 0; k < chance; k++){
			int firstBlockXCoord = chunkX + random.nextInt(16);
        	int firstBlockYCoord = random.nextInt(64);
        	int firstBlockZCoord = chunkZ + random.nextInt(16);
        	
        	(new WorldGenMinable(block, blocksPerVein)).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		}
	}

}
