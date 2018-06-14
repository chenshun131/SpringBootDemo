package com.webfin.websocket.handle;

import java.util.ArrayList;

import com.webfin.websocket.EventConst;
import com.webfin.websocket.dao.DeviceAccountDao;
import com.webfin.websocket.entity.DeviceAccount;
import com.webfin.websocket.event.BaseEvent;

public class DBEventHandleImpl implements EventHandle,Runnable {

	private DeviceAccountDao daDao = new DeviceAccountDao();
	private BaseEvent receiveEvent = null;
	private BaseEvent responseEvent = null;
	private boolean isFinish = false;
	
	//get/set
	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public BaseEvent getReceiveEvent() {
		return receiveEvent;
	}

	public void setReceiveEvent(BaseEvent receiveEvent) {
		this.receiveEvent = receiveEvent;
	}
	

	public BaseEvent getResponseEvent() {
		return responseEvent;
	}

	public void setResponseEvent(BaseEvent responseEvent) {
		this.responseEvent = responseEvent;
	}
	
	
		

	@Override
	public void HandleEvent() {
		int eventType = this.receiveEvent.getEventType();
		ArrayList<DeviceAccount> lsDevices = (ArrayList<DeviceAccount>)this.receiveEvent.getEventObjs();

		//A/B���豸��¼�¼�
		//1��������statusΪ���ߣ������µ���λ����Ϣ�����ظ��豸����
		if(eventType==EventConst.EVENT_A_LOGIN||eventType==EventConst.EVENT_B_LOGIN){
			DeviceAccount da = (DeviceAccount)lsDevices.get(0);
			da.setStatus("online");
			daDao.update(da);
		}

		//A�豸�����¼�
		//1����ѯ���豸��Ϣ
		//2�����¸��豸����λ�ã������¼�����豸��Ŀ��λ��
		if(eventType==EventConst.EVENT_A_REPAIRE){
			DeviceAccount da = (DeviceAccount)lsDevices.get(0);			
			daDao.update(da);
			DeviceAccount targetDa = daDao.mathTargetDevice(da);
			ArrayList<DeviceAccount> groupDevices = daDao.getGroupDevices(da);
			lsDevices.clear();
			lsDevices.addAll(groupDevices);
			lsDevices.add(targetDa);
			this.receiveEvent.setEventType(EventConst.EVENT_MATCHMATIC_RESULT);
			this.receiveEvent.setEventObjs(lsDevices);

		}
		//B�豸�ƶ��¼�
		//1����ѯ���豸��Ϣ
		//2�����¼�����豸���Ŀ��λ��
		if(eventType==EventConst.EVENT_B_UPDATING){
			DeviceAccount da = (DeviceAccount)lsDevices.get(0);			
			da.setStatus("online");
			daDao.update(da);
			DeviceAccount targetDa = daDao.mathTargetDevice(da);
			ArrayList<DeviceAccount> groupDevices = daDao.getGroupDevices(da);
			lsDevices.clear();
			lsDevices.addAll(groupDevices);
			if(targetDa.getLat()!=0&&targetDa.getLat()!=0){
				lsDevices.add(targetDa);
			}			
			this.receiveEvent.setEventType(EventConst.EVENT_MATCHMATIC_RESULT);
			this.receiveEvent.setEventObjs(lsDevices);

		}
		//�����¼�
		if(eventType==EventConst.EVENT_MATHMATIC){
			DeviceAccount da = (DeviceAccount)lsDevices.get(0);
			DeviceAccount targetDa = daDao.mathTargetDevice(da);
			ArrayList<DeviceAccount> groupDevices = daDao.getGroupDevices(da);
			lsDevices.clear();
			lsDevices.addAll(groupDevices);
			lsDevices.add(targetDa);
			this.receiveEvent.setEventType(EventConst.EVENT_MATCHMATIC_RESULT);
			this.receiveEvent.setEventObjs(lsDevices);


		}
		//A����B���豸����
		//1:����״̬
		//2:���¼���ͬ��Ŀ��λ��
		if(eventType==EventConst.EVENT_A_LOGOFF)
		{		
			DeviceAccount da = (DeviceAccount)lsDevices.get(0);
			da.setStatus("offline");
			daDao.update(da);
			DeviceAccount targetDa = daDao.mathTargetDevice(da);
			ArrayList<DeviceAccount> groupDevices = daDao.getGroupDevices(da);
			lsDevices.clear();
			lsDevices.addAll(groupDevices);
			lsDevices.add(targetDa);
			this.receiveEvent.setEventObjs(lsDevices);
			this.receiveEvent.setEventType(EventConst.EVENT_MATCHMATIC_RESULT);
			
		}
		//B�豸����
		if(eventType==EventConst.EVENT_B_LOGOFF){
			DeviceAccount da = (DeviceAccount)lsDevices.get(0);
			da.setStatus("offline");
			daDao.update(da);
		}
		this.isFinish=true;


	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.HandleEvent();
	}

}
