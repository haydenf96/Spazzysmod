package spazzysmod.world;

import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import spazzysmod.world.biome.SpazzysBiomes;
import spazzysmod.world.chunk.ChunkManagerMoon;

public class WorldProviderMoon extends WorldProvider {

    @Override
    public float calculateCelestialAngle(long par1, float par3) {
        int var4 = (int) (par1 % 24000L);
        float var5 = (var4 + par3) / 24000.0F - 0.25F;

        if (var5 < 0.0F) {
            ++var5;
        }

        if (var5 > 1.0F) {
            --var5;
        }

        float var6 = var5;
        var5 = 1.0F - (float) ((Math.cos(var5 * Math.PI) + 1.0D) / 2.0D);
        var5 = var6 + (var5 - var6) / 3.0F;
        return var5;
    }

    /*
     * public String getSunTexture() { return
     * "/path/to/your/sun/texture.png"; }
     * 
     * public String getMoonTexture() { return
     * "/path/to/your/moon/texture.png"; }
     */

    @Override
    public boolean canRespawnHere() {
        return true;
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkManagerMoon(this.worldObj, this.worldObj.getSeed(),
                hasNoSky);
    }

    @Override
    public boolean doesXZShowFog(int par1, int par2) {
        return false;
    }

    @Override
    public Vec3 drawClouds(float partialTicks) {
        return worldObj.drawCloudsBody(partialTicks);
    }

    @Override
    public String getDimensionName() {
        return "Moon";
    }

    @Override
    public String getWelcomeMessage() {
        return "Flying to the Moon...";
    }

    @Override
    public boolean isSkyColored() {
        return true;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(SpazzysBiomes.moonBiome,
                1.0F, 0.0F);
        this.isHellWorld = false;
        this.hasNoSky = true;
        this.dimensionId = SpazzysDimensions.moonDimensionID;
    }
}