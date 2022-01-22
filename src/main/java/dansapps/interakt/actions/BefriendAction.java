package dansapps.interakt.actions;

import dansapps.interakt.actions.abs.Action;
import dansapps.interakt.factories.EventFactory;
import dansapps.interakt.objects.Actor;
import dansapps.interakt.objects.Event;
import dansapps.interakt.utils.Logger;

/**
 * @author Daniel McCoy Stephenson
 * @since January 22nd, 2022
 */
public class BefriendAction implements Action {

    public static void befriend(Actor actor, Actor other) {
        if (actor.isFriend(other)) {
            return;
        }
        actor.addFriend(other);
        other.addFriend(actor);
        Event event = EventFactory.getInstance().createEvent(actor.getName() + " and " + other.getName() + " are now friends.");
        Logger.getInstance().logEvent(event);
    }
}
