/*
 * IRCReplyAdapter.java
 *
 * Created on 26 July 2002, 09:42
 */

package net.munki.irc.handlers.reply;

import net.munki.irc.event.IRCReplyEvent;
import net.munki.irc.event.IRCReplyListener;
import net.munki.irc.protocol.rfc2812.ReplyHandlerException;

/** Convenience adapter providing empty implementations of IRC reply messages. */
public abstract class IRCReplyAdapter implements IRCReplyInterface, IRCReplyListener {

    /** Creates new IRCReplyAdapter */
    public IRCReplyAdapter() {
    }

    /** Dispatcher method responsible for handling IRC reply events.
     * @param evt The IRC reply event to handle
     * @throws ReplyHandlerException Thrown when a handler fails to handle the dispatched message.
     */
    public abstract void dispatch(IRCReplyEvent evt) throws ReplyHandlerException;
    
    /**
     * @param reply
     */    
    public void RPL_WHOISCHANOP(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSVLINE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_UNKNOWNCOMMAND(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_YOUWILLBEBANNED(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_WHOISIDLE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOSUCHSERVICE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFSTATS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ADMINEMAIL(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSCLINE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_UMODEUNKNOWNFLAG(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACEOPERATOR(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOSUCHSERVER(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACELOG(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFSERVICES(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_SUMMONDISABLED(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_CANTKILLSERVER(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_YOUREOPER(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSILINE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_FILEERROR(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_SERVICEINFO(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOTEXTTOSEND(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_RESTRICTED(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSPING(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NEEDMOREPARAMS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_LISTEND(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_LUSERUNKNOWN(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSNLINE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_CREATED(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_CHANNELMODEIS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFBANLIST(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_BADCHANNELKEY(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_USERSDONTMATCH(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ISON(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_INVITEONLYCHAN(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_LINKS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSHLINE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_BANLISTFULL(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_LISTSTART(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_CANNOTSENDTOCHAN(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_LUSERME(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSCOMMANDS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_USERS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_WHOISSERVER(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_AWAY(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACECONNECTING(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOSUCHCHANNEL(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TOPIC(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_USERONCHANNEL(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_LUSERCLIENT(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_UNAWAY(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_PASSWDMISMATCH(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOPRIVILEGES(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOTREGISTERED(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_UMODEIS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_MYINFO(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOSUCHNICK(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_UNAVAILRESOURCE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_USERSDISABLED(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_MYPORTIS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_INFOSTART(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_BOUNCE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOLOGIN(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOTOPLEVEL(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NORECIPIENT(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACESERVER(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFEXCEPTLIST(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_NOWAWAY(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACENEWTYPE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_YOURESERVICE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_USERNOTINCHANNEL(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_INVITELIST(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACESERVICE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFNAMES(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACERECONNECT(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_REHASHING(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_MOTD(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACECLASS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACEEND(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFINFO(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACEUNKNOWN(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOOPERHOST(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_INVITING(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSSLINE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSLLINE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFLINKS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_WASNOSUCHNICK(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_TOOMANYTARGETS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACEUSER(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_WHOISCHANNELS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_UNIQOPIS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_NOUSERS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_LUSERCHANNELS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSLINKINFO(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_WHOWASUSER(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSKLINE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOCHANMODES(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFMOTD(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_UNIQOPPRIVSNEEDED(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSYLINE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_KEYSET(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_KILLDONE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ADMINLOC1(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ADMINME(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_BADCHANMASK(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_SUMMONING(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_CHANOPRIVSNEEDED(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_TOOMANYCHANNELS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSBLINE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NICKCOLLISION(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFUSERS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TIME(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_MOTDSTART(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRYAGAIN(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_ERRONEUSNICKNAME(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_NAMREPLY(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSOLINE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_SERVICE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_WHOISUSER(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFINVITELIST(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSQLINE(String reply) {
    }
    
    /**
     * @throws ReplyHandlerException
     */    
    public void ERR_NICKNAMEINUSE() throws ReplyHandlerException {
    }
    
    /**
     * @param reply
     */    
    public void ERR_YOUREBANNEDCREEP(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSUPTIME(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFWHOWAS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_UNKNOWNMODE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_SERVLISTEND(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_LUSEROP(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_CLOSEEND(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_USERSSTART(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOMOTD(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_LIST(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOORIGIN(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_WHOISOPERATOR(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFWHO(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_CLOSING(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOADMININFO(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_NONE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_BADMASK(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_WHOREPLY(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ADMINLOC2(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_YOURHOST(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NONICKNAMEGIVEN(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_WILDTOPLEVEL(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOTONCHANNEL(String reply) {
    }
    
    /**
     * @throws ReplyHandlerException
     */    
    public void RPL_WELCOME() throws ReplyHandlerException {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACELINK(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_STATSDLINE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_TRACEHANDSHAKE(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_BANNEDFROMCHAN(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_SERVLIST(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_NOPERMFORHOST(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_NOTOPIC(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_USERHOST(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_BANLIST(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_ALREADYREGISTERED(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_EXCEPTLIST(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_ENDOFWHOIS(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_VERSION(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void RPL_INFO(String reply) {
    }
    
    /**
     * @param reply
     */    
    public void ERR_CHANNELISFULL(String reply) {
    }
    
}
