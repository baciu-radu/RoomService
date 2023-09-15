package com.ps.bk.hotel.room.service.impl;


import com.ps.bk.hotel.room.exception.RoomServiceClientException;
import com.ps.bk.hotel.room.model.Room;
import com.ps.bk.hotel.room.repo.RoomRepo;
import com.ps.bk.hotel.room.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
	private RoomRepo repo;

	public RoomServiceImpl(RoomRepo repo) {
		this.repo = repo;
	}

	@Override
	public Iterable<Room> getAllRooms() {
		return repo.findAll();
	}

	@Override
	public Optional<Room> findRoom(long roomId) {
		return repo.findById(roomId);
	}

	@Override
	public void updateRoom(Room room) {
		repo.save(room);
	}

	@Override
	public void addRoom(Room room) {
		repo.save(room);
	}

	@Override
	public Room findByRoomNumber(String roomNumber) {
		if (!com.ps.bk.hotel.room.utils.StringUtils.isNullOrEmpty(roomNumber) && com.ps.bk.hotel.room.utils.StringUtils.isNumber(roomNumber)) {
			Room room = repo.findByRoomNumber(roomNumber);
			if (room == null) {
				throw new RoomServiceClientException("Room number: " + roomNumber + ", does not exist.");
			}
			return room;
		}
		else {
			throw new RoomServiceClientException("Room number: " + roomNumber + ", is an invalid room number format.");
		}
	}

}
