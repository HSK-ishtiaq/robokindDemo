ouble i = 0.0; i<=1.0; i+=this.interval) {
        	// printing
        	if (this.printOut) {
        		System.out.println("Moving joint to position "+i+" over "+this.timeFrame+" milliseconds:");
        	}
        	myGoalPositions.put(joint, new NormalizedDouble(i));
			// move over specified time
        	myRobot.move(myGoalPositions, this.timeFrame);  
                Robokind.sleep(2000);
        }
        // completion message
  		System.out.println("Test complete using joint number: "+this.jointIndex);
  		double defaultPosition;
  		// There has GOT to be an easier way of doing this...
  		switch (this.jointIndex) {
			// set joint
			case 100: defaultPosition = 0.5;
				break;
			case 200: defaultPosition = 0.5;
				break;
			case 201: defaultPosition = 0.5;
				break;
			case 202: defaultPosition = 0.5;
				break;
			case 300: defaultPosition = 0.542372881355932;
				break;
			case 301: defaultPosition = 0.442105263157895; 
				break;
			case 310: defaultPosition = 0.67;
				break;
			case 311: defaultPosition = 0.5; 
				break;
			case 312: defaultPosition = 0.5; 
				break;				
			case 320: defaultPosition = 0.5; 
				break;
			case 321: defaultPosition = 0.5; 
				break;				
			case 322: defaultPosition = 0.364464692482916;
				break;
			case 400: defaultPosition = 0.185185185185185;
				break; 
			case 401: defaultPosition = 0.055555555555556;
				break;
			case 410: defaultPosition = 0.5;
				break;
			case 411: defaultPosition = 0.111111111111111;
				break;
			case 420: defaultPosition = 0.5;
				break;
			case 421: defaultPosition = 0.5;
				break;
			case 500: defaultPosition = 0.185185185185185;
				break; 
			case 501: defaultPosition = 0.055555555555556; 
				break;
			case 510: defaultPosition = 0.5;
				break;
			case 511: defaultPosition = 0.111111111111111;
				break;
			case 520: defaultPosition = 0.5; 
				break;
			case 521: defaultPosition = 0.5;
				break;
			case 600: defaultPosition = 0.2; 
				break;
			case 601: defaultPosition = 0.181818181818182;
				break;	
			case 602: defaultPosition = 0.1;
				break;
			case 610: defaultPosition = 0.909090909090909;
				break;
			case 620: defaultPosition = 0.7;
				break;
			case 621: defaultPosition = 0.5;
				break;
			case 700: defaultPosition = 0.2;
				break;
			case 701: defaultPosition = 0.818181818181818;
				break;	
			case 702: defaultPosition = 0.1;
				break;
			case 710: defaultPosition = 0.909090909090909;
				break;
			case 720: defaultPosition = 0.7;
				break;
			case 721: defaultPosition = 0.5;
				break;				
			default: defaultPosition = 0.5;
		}
		if (printOut) {
			System.out.println("Now setting joint to default value: "+defaultPosition);
		}	
  		// set to default
		myGoalPositions.put(joint, new NormalizedDouble(defaultPosition));
		// move over 2000 milliseconds
                myRobot.move(myGoalPositions, 2000);
	}
}
