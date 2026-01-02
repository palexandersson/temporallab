package se.maxm.temporallab.temporal;

import io.temporal.spring.boot.WorkflowImpl;
import io.temporal.workflow.Workflow;
import org.springframework.stereotype.Component;

import static se.maxm.temporallab.temporal.CloseMeetingDetailWorkflow.TASK_QUEUE_CLOSE_MEETING;

@Component
@WorkflowImpl(taskQueues = TASK_QUEUE_CLOSE_MEETING)
public class CloseMeetingDetailWorkflowImpl implements CloseMeetingDetailWorkflow {
    CloseMeetingActivities closeMeetingActivities;
    String status;

    public CloseMeetingDetailWorkflowImpl(CloseMeetingActivities closeMeetingActivities) {
        this.closeMeetingActivities = closeMeetingActivities;
    }

    @Override
    public void closeMeeting(Long meetingDetailsId) {

        //-- fetch meeting
        MeetingDetail meetingDetail = new MeetingDetail(meetingDetailsId, "Meeting no " + meetingDetailsId);


        //-- close suitability
        status = "lockSuitability";
        closeMeetingActivities.lockSuitability(meetingDetail);

        //-- createFactSheet
        status = "createFactSheet";
        closeMeetingActivities.createFactSheet(meetingDetail);

        //-- create pdf
        status = "createPdf";
        closeMeetingActivities.createPdf(meetingDetail);

        //-- send mail to customer
        status = "sendMailToCustomer";
        closeMeetingActivities.sendMailToCustomer(meetingDetail);

        //-- sendAmlMail
        status = "sendAmlMail";
        closeMeetingActivities.sendAmlMail(meetingDetail);

        status = "done";

    }

    @Override
    public String getStatus() {
        return "";
    }
}
