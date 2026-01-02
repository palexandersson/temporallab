package se.maxm.temporallab.temporal;

import io.temporal.workflow.QueryMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface CloseMeetingDetailWorkflow {

    static String TASK_QUEUE_CLOSE_MEETING = "TASK_QUEUE_CLOSE_MEETING";

    @WorkflowMethod
    void closeMeeting(Long meetingDetailsId);

    @QueryMethod
    String getStatus();
}
