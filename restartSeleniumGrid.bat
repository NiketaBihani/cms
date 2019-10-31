echo Kill all javaw (Selenium) processes
taskkill /f /im "javaw.exe"

rem echo Kill all java (Selenium) processes
rem taskkill /f /im "java.exe"

rem ping -n 3 127.0.0.1>nul

echo Starting Selenium hubs and grid

start /max /D "C:\Users\Administrator\Desktop\Selenium" selenium-server-standalone-2.44.0.jar -role hub
ping -n 3 127.0.0.1>nul


start /max /D "C:\Users\Administrator\Desktop\Selenium" selenium-server-standalone-2.44.0.jar -role node -hub http://localhost:4444/grid/register
ping -n 3 127.0.0.1>nul

start /max /D "C:\Users\Administrator\Desktop\Selenium" slave.jar -jnlpUrl http://manager.hmh.ixxus.co.uk/computer/SeleniumServerHMH/slave-agent.jnlp -secret 939a41f2fc3f7d1be2a5e9ead190420f02b06b1d5164f90d4dda9ce55960b724
ping -n 3 127.0.0.1>nul

exit