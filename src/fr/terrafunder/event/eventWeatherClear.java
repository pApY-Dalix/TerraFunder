package fr.terrafunder.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class eventWeatherClear implements Listener
{
    @EventHandler
    public void onWeather (WeatherChangeEvent event)
    {
        if(event.toWeatherState())
        {
            event.setCancelled(true);
        }
    }
}
