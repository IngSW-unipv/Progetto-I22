package it.unipv.po.cosi.restaurant.controller;

import it.unipv.po.cosi.restaurant.model.orderModel.Status;
import it.unipv.po.cosi.restaurant.model.orderModel.Table;
import it.unipv.po.cosi.restaurant.view.CassaView;
import java.awt.*;
import java.awt.event.*;

public class Controller {

	private final CassaView view;
	
	private ActionListener tableSelectionListener;
	private ActionListener categorySelectionListener;
	private ActionListener servingSelectionListener;
	private ActionListener increaseQuantityListener;
	private ActionListener decreaseQuantityListener;
	private ActionListener removeServingListener;
	private ActionListener moveUpListener;
	private ActionListener moveDownListener;
	private ActionListener addModListener;
	private ActionListener removeModListener;
	private ActionListener sendOrderListener;
	
	
	public Controller(CassaView view) {
		
		this.view = view;
		
	}
	
	
}
