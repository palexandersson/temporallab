package se.maxm.temporallab.temporal;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface CloseMeetingActivities {

    void sendMailToCustomer(MeetingDetail meetingDetail);
    void createPdf(MeetingDetail meetingDetail);
    void lockSuitability(MeetingDetail meetingDetail);
    void sendAmlMail(MeetingDetail meetingDetail);
    void createFactSheet(MeetingDetail meetingDetail);

}
