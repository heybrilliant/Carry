package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.chatting.ChatListDto;
import com.project.gymcarry.chatting.ChatRoomDto;
import com.project.gymcarry.programinfo.PrograminfoDto;

// Payment DAO
public interface PrograminfoDao {
	
	// 결제 정보
	List<PrograminfoDto> selectProgramInfo(int proIDX);

}
