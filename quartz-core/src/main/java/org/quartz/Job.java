
/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 */

package org.quartz;

/**
 * 是一个接口，只有一个方法，开发者通过实现该接口定义需要执行的任务，JobExecutionContext类提供了调度上下文的各种信息。
 * Job运行时的 信息保存在JobDataMap实例中
 * 由表示要执行的“作业”的类实现的接口。
 *
 * 要由表示要执行的“作业”的类实现的接口。只有一个方法 void execute(jobExecutionContext context)，(jobExecutionContext 提供调度上下文各种信息，运行时数据保存在jobDataMap中)
 *
 * Job有个子接口StatefulJob ,代表有状态任务。有状态任务不可并发，前次任务没有执行完，后面任务处于阻塞等到。
 *
 * <p>
 * The interface to be implemented by classes which represent a 'job' to be
 * performed.
 * </p>
 *
 * <p>
 * Instances of <code>Job</code> must have a <code>public</code>
 * no-argument constructor.
 * </p>
 *
 * <p>
 * <code>JobDataMap</code> provides a mechanism for 'instance member data'
 * that may be required by some implementations of this interface.
 * </p>
 *
 * @author James House
 * @see JobDetail
 * @see JobBuilder
 * @see ExecuteInJTATransaction
 * @see DisallowConcurrentExecution
 * @see PersistJobDataAfterExecution
 * @see Trigger
 * @see Scheduler
 */
public interface Job {

    /*
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *
     * Interface.
     *
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     */

    /**
     * 调用执行的方法
     * <p>
     * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code>
     * fires that is associated with the <code>Job</code>.
     * </p>
     *
     * <p>
     * The implementation may wish to set a
     * {@link JobExecutionContext#setResult(Object) result} object on the
     * {@link JobExecutionContext} before this method exits.  The result itself
     * is meaningless to Quartz, but may be informative to
     * <code>{@link JobListener}s</code> or
     * <code>{@link TriggerListener}s</code> that are watching the job's
     * execution.
     * </p>
     *
     * @throws JobExecutionException if there is an exception while executing the job.
     */
    void execute(JobExecutionContext context)
            throws JobExecutionException;

}
