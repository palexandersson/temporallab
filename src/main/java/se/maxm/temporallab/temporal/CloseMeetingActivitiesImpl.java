package se.maxm.temporallab.temporal;


import io.temporal.spring.boot.ActivityImpl;
import org.springframework.stereotype.Component;

import static se.maxm.temporallab.temporal.CloseMeetingDetailWorkflow.TASK_QUEUE_CLOSE_MEETING;
import static se.maxm.temporallab.temporal.Utils.sov;

@Component
@ActivityImpl(taskQueues = TASK_QUEUE_CLOSE_MEETING)
public class CloseMeetingActivitiesImpl implements CloseMeetingActivities {
    @Override
    public void sendMailToCustomer(MeetingDetail meetingDetail) {
        try {
            sov(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("logging sendMailToCustomer");
    }

    @Override
    public void createPdf(MeetingDetail meetingDetail) {
        try {
            sov(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("logging createPdf");
    }

    @Override
    public void lockSuitability(MeetingDetail meetingDetail) {
        try {
            sov(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("logging lockSuitability");
    }

    @Override
    public void sendAmlMail(MeetingDetail meetingDetail) {
        try {
            sov(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("logging sendAmlMail");
    }

    @Override
    public void createFactSheet(MeetingDetail meetingDetail) {
        try {
            sov(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("logging createFactSheet");
    }


}
