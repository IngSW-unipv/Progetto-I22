package it.unipv.po.cosi.restaurant.exception;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import it.unipv.po.cosi.restaurant.testers.GUITest;
import it.unipv.po.cosi.restaurant.view2.WarningFrame;

public class WarningFrameException extends Throwable{

	public WarningFrameException(String s) {
		
		WarningFrame warning = new WarningFrame(s);
		warning.setVisible(true);
		
		ActionListener confirmWarningListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					manageAction2();
				} catch (IOException e1) {
				
					
				}
			}
			
			private void manageAction2() throws IOException {
				
				
				StringBuilder cmd = new StringBuilder();
		        cmd.append(System.getProperty("java.home") + File.separator + "bin" + File.separator + "java ");
		        for (String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
		            cmd.append(jvmArg + " ");
		        }
		        cmd.append("-cp ").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append(" ");
		        cmd.append(GUITest.class.getName()).append(" ");
		        
		        Runtime.getRuntime().exec(cmd.toString());
		        System.exit(0);
		    }
				
			
		};
		warning.getConfirmButton().addActionListener(confirmWarningListener);
		
		ActionListener ignoreWarningListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageAction3();
				
			}
			
			private void manageAction3() {
				warning.dispose();
			}
		};
	
	warning.getIgnoreButton().addActionListener(ignoreWarningListener);
		
		
	}
}
