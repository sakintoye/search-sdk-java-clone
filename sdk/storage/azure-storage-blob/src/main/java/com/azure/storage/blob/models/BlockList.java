// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.blob.models;

import com.azure.core.implementation.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * The BlockList model.
 */
@JacksonXmlRootElement(localName = "BlockList")
@Fluent
public final class BlockList {
    private static final class CommittedBlocksWrapper {
        @JacksonXmlProperty(localName = "Block")
        private final List<Block> items;

        @JsonCreator
        private CommittedBlocksWrapper(@JacksonXmlProperty(localName = "Block") List<Block> items) {
            this.items = items;
        }
    }

    /*
     * The committedBlocks property.
     */
    @JsonProperty(value = "CommittedBlocks")
    private CommittedBlocksWrapper committedBlocks;

    private static final class UncommittedBlocksWrapper {
        @JacksonXmlProperty(localName = "Block")
        private final List<Block> items;

        @JsonCreator
        private UncommittedBlocksWrapper(@JacksonXmlProperty(localName = "Block") List<Block> items) {
            this.items = items;
        }
    }

    /*
     * The uncommittedBlocks property.
     */
    @JsonProperty(value = "UncommittedBlocks")
    private UncommittedBlocksWrapper uncommittedBlocks;

    /**
     * Get the committedBlocks property: The committedBlocks property.
     *
     * @return the committedBlocks value.
     */
    public List<Block> committedBlocks() {
        if (this.committedBlocks == null) {
            this.committedBlocks = new CommittedBlocksWrapper(new ArrayList<Block>());
        }
        return this.committedBlocks.items;
    }

    /**
     * Set the committedBlocks property: The committedBlocks property.
     *
     * @param committedBlocks the committedBlocks value to set.
     * @return the BlockList object itself.
     */
    public BlockList committedBlocks(List<Block> committedBlocks) {
        this.committedBlocks = new CommittedBlocksWrapper(committedBlocks);
        return this;
    }

    /**
     * Get the uncommittedBlocks property: The uncommittedBlocks property.
     *
     * @return the uncommittedBlocks value.
     */
    public List<Block> uncommittedBlocks() {
        if (this.uncommittedBlocks == null) {
            this.uncommittedBlocks = new UncommittedBlocksWrapper(new ArrayList<Block>());
        }
        return this.uncommittedBlocks.items;
    }

    /**
     * Set the uncommittedBlocks property: The uncommittedBlocks property.
     *
     * @param uncommittedBlocks the uncommittedBlocks value to set.
     * @return the BlockList object itself.
     */
    public BlockList uncommittedBlocks(List<Block> uncommittedBlocks) {
        this.uncommittedBlocks = new UncommittedBlocksWrapper(uncommittedBlocks);
        return this;
    }
}
