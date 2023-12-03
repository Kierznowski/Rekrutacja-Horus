package org.rekrutacjaHorus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure, CompositeBlock{

    private List<Block> blocks;

    public Wall (List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> blocksByMaterial = new ArrayList<>();
        for (Block block : blocks) {
            if (block.getMaterial().equals(material)) {
                blocks.add(block);
            }
        }
        return blocksByMaterial;
    }

    @Override
    public int count() {
        return blocks.size();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public String getColor() {
        return blocks.isEmpty() ? "" : blocks.get(0).getColor();
    }

    @Override
    public String getMaterial() {
        return blocks.isEmpty() ? "" : blocks.get(0).getMaterial();
    }
}
