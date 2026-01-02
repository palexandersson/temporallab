package se.maxm.temporallab.temporal;


import io.temporal.spring.boot.ActivityImpl;
import org.springframework.stereotype.Component;

import static se.maxm.temporallab.temporal.CloseMeetingDetailWorkflow.TASK_QUEUE_CLOSE_MEETING;

@Component
@ActivityImpl(taskQueues = TASK_QUEUE_CLOSE_MEETING)
public class CloseMeetingActivitiesImpl implements CloseMeetingActivities {
    @Override
    public void sendMailToCustomer(MeetingDetail meetingDetail) {
        sov(2000);
        System.out.println("logging sendMailToCustomer");
    }

    @Override
    public void createPdf(MeetingDetail meetingDetail) {
        sov(2000);
        System.out.println("logging createPdf");
    }

    @Override
    public void lockSuitability(MeetingDetail meetingDetail) {
        sov(2000);
        System.out.println("logging lockSuitability");
    }

    @Override
    public void sendAmlMail(MeetingDetail meetingDetail) {
        sov(2000);
        System.out.println("logging sendAmlMail");
    }

    @Override
    public void createFactSheet(MeetingDetail meetingDetail) {
        sov(2000);
        System.out.println("logging createFactSheet");
    }
    private static void sov(long millis) {
        try {
             Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
