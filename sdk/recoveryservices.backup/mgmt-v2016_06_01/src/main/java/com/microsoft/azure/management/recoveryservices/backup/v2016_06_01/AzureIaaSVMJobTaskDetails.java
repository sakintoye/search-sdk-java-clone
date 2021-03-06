/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices.backup.v2016_06_01;

import org.joda.time.DateTime;
import org.joda.time.Period;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Azure IaaS VM workload-specific job task details.
 */
public class AzureIaaSVMJobTaskDetails {
    /**
     * The task display name.
     */
    @JsonProperty(value = "taskId")
    private String taskId;

    /**
     * The start time.
     */
    @JsonProperty(value = "startTime")
    private DateTime startTime;

    /**
     * The end time.
     */
    @JsonProperty(value = "endTime")
    private DateTime endTime;

    /**
     * The instance ID.
     */
    @JsonProperty(value = "instanceId")
    private String instanceId;

    /**
     * The time elapsed for the task.
     */
    @JsonProperty(value = "duration")
    private Period duration;

    /**
     * The status.
     */
    @JsonProperty(value = "status")
    private String status;

    /**
     * The progress of the task, as a percentage.
     */
    @JsonProperty(value = "progressPercentage")
    private Double progressPercentage;

    /**
     * Get the task display name.
     *
     * @return the taskId value
     */
    public String taskId() {
        return this.taskId;
    }

    /**
     * Set the task display name.
     *
     * @param taskId the taskId value to set
     * @return the AzureIaaSVMJobTaskDetails object itself.
     */
    public AzureIaaSVMJobTaskDetails withTaskId(String taskId) {
        this.taskId = taskId;
        return this;
    }

    /**
     * Get the start time.
     *
     * @return the startTime value
     */
    public DateTime startTime() {
        return this.startTime;
    }

    /**
     * Set the start time.
     *
     * @param startTime the startTime value to set
     * @return the AzureIaaSVMJobTaskDetails object itself.
     */
    public AzureIaaSVMJobTaskDetails withStartTime(DateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the end time.
     *
     * @return the endTime value
     */
    public DateTime endTime() {
        return this.endTime;
    }

    /**
     * Set the end time.
     *
     * @param endTime the endTime value to set
     * @return the AzureIaaSVMJobTaskDetails object itself.
     */
    public AzureIaaSVMJobTaskDetails withEndTime(DateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Get the instance ID.
     *
     * @return the instanceId value
     */
    public String instanceId() {
        return this.instanceId;
    }

    /**
     * Set the instance ID.
     *
     * @param instanceId the instanceId value to set
     * @return the AzureIaaSVMJobTaskDetails object itself.
     */
    public AzureIaaSVMJobTaskDetails withInstanceId(String instanceId) {
        this.instanceId = instanceId;
        return this;
    }

    /**
     * Get the time elapsed for the task.
     *
     * @return the duration value
     */
    public Period duration() {
        return this.duration;
    }

    /**
     * Set the time elapsed for the task.
     *
     * @param duration the duration value to set
     * @return the AzureIaaSVMJobTaskDetails object itself.
     */
    public AzureIaaSVMJobTaskDetails withDuration(Period duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Get the status.
     *
     * @return the status value
     */
    public String status() {
        return this.status;
    }

    /**
     * Set the status.
     *
     * @param status the status value to set
     * @return the AzureIaaSVMJobTaskDetails object itself.
     */
    public AzureIaaSVMJobTaskDetails withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get the progress of the task, as a percentage.
     *
     * @return the progressPercentage value
     */
    public Double progressPercentage() {
        return this.progressPercentage;
    }

    /**
     * Set the progress of the task, as a percentage.
     *
     * @param progressPercentage the progressPercentage value to set
     * @return the AzureIaaSVMJobTaskDetails object itself.
     */
    public AzureIaaSVMJobTaskDetails withProgressPercentage(Double progressPercentage) {
        this.progressPercentage = progressPercentage;
        return this;
    }

}
