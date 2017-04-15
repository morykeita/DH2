package com.dhub.dao;

import java.util.List;

import com.dhub.beans.Meetings;

public interface MeetingsDao {
	public List<Meetings> getAllMeetings();
	public void createMeeting(Meetings m);
	public void updateMeeting(Meetings m);
	public void deleteMeeting(Meetings m);
}
