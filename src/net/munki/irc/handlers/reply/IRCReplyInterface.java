/*
 * IRCMessageInterface.java
 *
 * Created on 23 July 2002, 14:56
 */

package net.munki.irc.handlers.reply;

import net.munki.irc.protocol.rfc2812.ReplyHandlerException;
import net.munki.irc.protocol.rfc2812.ReplyHandlerInterface;

/** A definition of IRC numeric reply messages. */
public interface IRCReplyInterface extends ReplyHandlerInterface {

    /**
     * @param reply
     */
    void ERR_NICKCOLLISION(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOSUCHNICK(String reply);
    
    /**
     * @param reply
     */
    void RPL_WHOISOPERATOR(String reply);
    
    /**
     * @param reply
     */
    void RPL_ENDOFBANLIST(String reply);
    
    /**
     * @param reply
     */
    void RPL_MYPORTIS(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSDLINE(String reply);
    
    /**
     * @param reply
     */
    void RPL_KILLDONE(String reply);
    
    /**
     * @param reply
     */
    void ERR_UNAVAILRESOURCE(String reply);
    
    /**
     * @param reply
     */
    void RPL_LUSERCHANNELS(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSYLINE(String reply);
    
    /**
     * @param reply
     */
    void RPL_NOWAWAY(String reply);
    
    /**
     * @param reply
     */
    void ERR_NEEDMOREPARAMS(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOCHANMODES(String reply);
    
    /**
     * @param reply
     */
    void ERR_WILDTOPLEVEL(String reply);
    
    /**
     * @param reply
     */
    void ERR_TOOMANYTARGETS(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSLINKINFO(String reply);
    
    /**
     * @param reply
     */
    void ERR_INVITEONLYCHAN(String reply);
    
    /**
     * @param reply
     */
    void RPL_LIST(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSOLINE(String reply);
    
    /**
     * @param reply
     */
    void RPL_CLOSEEND(String reply);
    
    /**
     * @param reply
     */
    void RPL_REHASHING(String reply);
    
    /**
     * @param reply
     */
    void RPL_ISON(String reply);
    
    /**
     * @param reply
     */
    void RPL_NOTOPIC(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOORIGIN(String reply);
    
    /**
     * @param reply
     */
    void RPL_ENDOFINFO(String reply);
    
    /**
     * @param reply
     */
    void RPL_BANLIST(String reply);
    
    /**
     * @param reply
     */
    void RPL_WHOISIDLE(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSPING(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSVLINE(String reply);
    
    /**
     * @param reply
     */
    void ERR_NONICKNAMEGIVEN(String reply);
    
    /**
     * @param reply
     */
    void RPL_INFO(String reply);
    
    /**
     * @throws ReplyHandlerException
     */
    void RPL_WELCOME() throws ReplyHandlerException;
    
    /**
     * @param reply
     */
    void RPL_ENDOFUSERS(String reply);
    
    /**
     * @param reply
     */
    void RPL_ENDOFSTATS(String reply);
    
    /**
     * @param reply
     */
    void ERR_PASSWDMISMATCH(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSUPTIME(String reply);
    
    /**
     * @param reply
     */
    void RPL_INVITING(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOSUCHCHANNEL(String reply);
    
    /**
     * @param reply
     */
    void ERR_TOOMANYCHANNELS(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOLOGIN(String reply);
    
    /**
     * @param reply
     */
    void ERR_RESTRICTED(String reply);
    
    /**
     * @param reply
     */
    void ERR_BANNEDFROMCHAN(String reply);
    
    /**
     * @param reply
     */
    void ERR_UNKNOWNMODE(String reply);
    
    /**
     * @param reply
     */
    void RPL_USERSSTART(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOTREGISTERED(String reply);
    
    /**
     * @param reply
     */
    void ERR_FILEERROR(String reply);
    
    /**
     * @param reply
     */
    void RPL_SERVLISTEND(String reply);
    
    /**
     * @param reply
     */
    void RPL_ENDOFMOTD(String reply);
    
    /**
     * @param reply
     */
    void ERR_USERNOTINCHANNEL(String reply);
    
    /**
     * @param reply
     */
    void RPL_SUMMONING(String reply);
    
    /**
     * @param reply
     */
    void RPL_ENDOFSERVICES(String reply);
    
    /**
     * @param reply
     */
    void ERR_WASNOSUCHNICK(String reply);
    
    /**
     * @param reply
     */
    void RPL_USERHOST(String reply);
    
    /**
     * @param reply
     */
    void ERR_CHANOPRIVSNEEDED(String reply);
    
    /**
     * @param reply
     */
    void RPL_YOURHOST(String reply);
    
    /**
     * @param reply
     */
    void ERR_CANTKILLSERVER(String reply);
    
    /**
     * @param reply
     */
    void ERR_KEYSET(String reply);
    
    /**
     * @param reply
     */
    void ERR_SUMMONDISABLED(String reply);
    
    /**
     * @param reply
     */
    void ERR_UNIQOPPRIVSNEEDED(String reply);
    
    /**
     * @param reply
     */
    void ERR_ERRONEUSNICKNAME(String reply);
    
    /**
     * @param reply
     */
    void RPL_NAMREPLY(String reply);
    
    /**
     * @param reply
     */
    void RPL_NOUSERS(String reply);
    
    /**
     * @param reply
     */
    void RPL_UMODEIS(String reply);
    
    /**
     * @param reply
     */
    void RPL_WHOISCHANOP(String reply);
    
    /**
     * @param reply
     */
    void RPL_LUSEROP(String reply);
    
    /**
     * @param reply
     */
    void RPL_SERVICE(String reply);
    
    /**
     * @param reply
     */
    void ERR_UMODEUNKNOWNFLAG(String reply);
    
    /**
     * @param reply
     */
    void RPL_LINKS(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOOPERHOST(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSQLINE(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACEEND(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOTOPLEVEL(String reply);
    
    /**
     * @param reply
     */
    void RPL_LUSERCLIENT(String reply);
    
    /**
     * @param reply
     */
    void RPL_LUSERUNKNOWN(String reply);
    
    /**
     * @param reply
     */
    void RPL_ADMINLOC2(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSCLINE(String reply);
    
    /**
     * @param reply
     */
    void RPL_ENDOFINVITELIST(String reply);
    
    /**
     * @param reply
     */
    void RPL_ENDOFLINKS(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOADMININFO(String reply);
    
    /**
     * @param reply
     */
    void RPL_YOURESERVICE(String reply);
    
    /**
     * @param reply
     */
    void RPL_ENDOFWHO(String reply);
    
    /**
     * @param reply
     */
    void ERR_NORECIPIENT(String reply);
    
    /**
     * @param reply
     */
    void RPL_ADMINLOC1(String reply);
    
    /**
     * @param reply
     */
    void ERR_BADCHANNELKEY(String reply);
    
    /**
     * @param reply
     */
    void ERR_BADMASK(String reply);
    
    /**
     * @param reply
     */
    void RPL_ENDOFWHOIS(String reply);
    
    /**
     * @param reply
     */
    void RPL_SERVICEINFO(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACELINK(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOSUCHSERVICE(String reply);
    
    /**
     * @param reply
     */
    void RPL_LISTEND(String reply);
    
    /**
     * @param reply
     */
    void RPL_INFOSTART(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSNLINE(String reply);
    
    /**
     * @param reply
     */
    void RPL_ENDOFEXCEPTLIST(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSKLINE(String reply);
    
    /**
     * @param reply
     */
    void ERR_BANLISTFULL(String reply);
    
    /**
     * @param reply
     */
    void RPL_MOTDSTART(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACECONNECTING(String reply);
    
    /**
     * @param reply
     */
    void RPL_MYINFO(String reply);
    
    /**
     * @param reply
     */
    void ERR_USERSDISABLED(String reply);
    
    /**
     * @param reply
     */
    void RPL_ENDOFWHOWAS(String reply);
    
    /**
     * @param reply
     */
    void ERR_YOUREBANNEDCREEP(String reply);
    
    /**
     * @param reply
     */
    void RPL_MOTD(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSHLINE(String reply);
    
    /**
     * @param reply
     */
    void RPL_CLOSING(String reply);
    
    /**
     * @throws ReplyHandlerException
     */
    void ERR_NICKNAMEINUSE() throws ReplyHandlerException;
    
    /**
     * @param reply
     */
    void RPL_TOPIC(String reply);
    
    /**
     * @param reply
     */
    void ERR_ALREADYREGISTERED(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSSLINE(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSLLINE(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOTEXTTOSEND(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACEOPERATOR(String reply);
    
    /**
     * @param reply
     */
    void ERR_BADCHANMASK(String reply);
    
    /**
     * @param reply
     */
    void RPL_CHANNELMODEIS(String reply);
    
    /**
     * @param reply
     */
    void RPL_INVITELIST(String reply);
    
    /**
     * @param reply
     */
    void RPL_UNIQOPIS(String reply);
    
    /**
     * @param reply
     */
    void ERR_CHANNELISFULL(String reply);
    
    /**
     * @param reply
     */
    void ERR_CANNOTSENDTOCHAN(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSBLINE(String reply);
    
    /**
     * @param reply
     */
    void RPL_WHOISCHANNELS(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSCOMMANDS(String reply);
    
    /**
     * @param reply
     */
    void RPL_NONE(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOPRIVILEGES(String reply);
    
    /**
     * @param reply
     */
    void RPL_BOUNCE(String reply);
    
    /**
     * @param reply
     */
    void ERR_YOUWILLBEBANNED(String reply);
    
    /**
     * @param reply
     */
    void RPL_ENDOFNAMES(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACELOG(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOTONCHANNEL(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOMOTD(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACESERVICE(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOSUCHSERVER(String reply);
    
    /**
     * @param reply
     */
    void ERR_USERONCHANNEL(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACECLASS(String reply);
    
    /**
     * @param reply
     */
    void ERR_UNKNOWNCOMMAND(String reply);
    
    /**
     * @param reply
     */
    void RPL_TIME(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACEHANDSHAKE(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACESERVER(String reply);
    
    /**
     * @param reply
     */
    void RPL_STATSILINE(String reply);
    
    /**
     * @param reply
     */
    void RPL_SERVLIST(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACENEWTYPE(String reply);
    
    /**
     * @param reply
     */
    void RPL_WHOWASUSER(String reply);
    
    /**
     * @param reply
     */
    void RPL_WHOREPLY(String reply);
    
    /**
     * @param reply
     */
    void ERR_NOPERMFORHOST(String reply);
    
    /**
     * @param reply
     */
    void RPL_VERSION(String reply);
    
    /**
     * @param reply
     */
    void RPL_USERS(String reply);
    
    /**
     * @param reply
     */
    void RPL_LUSERME(String reply);
    
    /**
     * @param reply
     */
    void RPL_UNAWAY(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACERECONNECT(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACEUNKNOWN(String reply);
    
    /**
     * @param reply
     */
    void RPL_LISTSTART(String reply);
    
    /**
     * @param reply
     */
    void ERR_USERSDONTMATCH(String reply);
    
    /**
     * @param reply
     */
    void RPL_EXCEPTLIST(String reply);
    
    /**
     * @param reply
     */
    void RPL_YOUREOPER(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRACEUSER(String reply);
    
    /**
     * @param reply
     */
    void RPL_WHOISUSER(String reply);
    
    /**
     * @param reply
     */
    void RPL_WHOISSERVER(String reply);
    
    /**
     * @param reply
     */
    void RPL_ADMINEMAIL(String reply);
    
    /**
     * @param reply
     */
    void RPL_TRYAGAIN(String reply);
    
    /**
     * @param reply
     */
    void RPL_ADMINME(String reply);
    
    /**
     * @param reply
     */
    void RPL_CREATED(String reply);
    
    /**
     * @param reply
     */
    void RPL_AWAY(String reply);
    
}

