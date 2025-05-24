# qrCode

This app consists of a Home Page with two buttons, one to generate a QR code with the endpoint provided
(QR Code), and one to scan a QR Code (Scan).

The QR Code button opens a new screen, displays a loader while the code is generated and then displays it,
and displays an error message if the endpoint fails.

The Scan button opens a new screen with the camera preview, and requests camera permission if they're not
granted. If the permissions are denied, an error message will be shown. After the code is scanned, 
a Toast message will be displayed, and then the app will return to the Home screen.

The UI is developed in Jetpack Compose.
Third party libraries were used for the QR code generation and scanning, plus the camera usage.

For the codes: zxing and MLKit. 

The architecture used for this app is MVVM, only using a ViewModel for the QR Code screen with the endpoint.
There's also a simplified version of clean architecture with all the layers divided in packages, having 
a UI layer, a Data layer and the Dependency Injection layer, using Koin, since it's a simple project.

There's a navigation graph to handle the navigation.
