/*
 * ReplyHandlerAdapter.java
 *
 * Created on 24 July 2002, 09:09
 */

package net.munki.irc.protocol.rfc2812;

public abstract class ReplyHandlerAdapter implements ReplyHandlerInterface {

    /** Creates new ReplyHandlerAdapter */
    public ReplyHandlerAdapter() {
    }

    public void ERR_NICKCOLLISION(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOSUCHNICK(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_WHOISOPERATOR(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ENDOFBANLIST(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_MYPORTIS(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSDLINE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_KILLDONE(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_UNAVAILRESOURCE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_LUSERCHANNELS(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSYLINE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_NOWAWAY(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NEEDMOREPARAMS(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOCHANMODES(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_WILDTOPLEVEL(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_TOOMANYTARGETS(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSLINKINFO(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_INVITEONLYCHAN(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_LIST(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSOLINE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_CLOSEEND(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_REHASHING(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ISON(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_NOTOPIC(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOORIGIN(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ENDOFINFO(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_BANLIST(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_WHOISIDLE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSPING(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSVLINE(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NONICKNAMEGIVEN(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_INFO(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_WELCOME(String reply) {
    }
    
    public void RPL_ENDOFUSERS(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ENDOFSTATS(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_PASSWDMISMATCH(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSUPTIME(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_INVITING(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOSUCHCHANNEL(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_TOOMANYCHANNELS(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOLOGIN(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_RESTRICTED(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_BANNEDFROMCHAN(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_UNKNOWNMODE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_USERSSTART(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOTREGISTERED(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_FILEERROR(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_SERVLISTEND(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ENDOFMOTD(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_USERNOTINCHANNEL(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_SUMMONING(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ENDOFSERVICES(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_WASNOSUCHNICK(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_USERHOST(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_CHANOPRIVSNEEDED(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_YOURHOST(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_CANTKILLSERVER(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_KEYSET(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_SUMMONDISABLED(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_UNIQOPPRIVSNEEDED(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_ERRONEUSNICKNAME(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_NAMREPLY(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_NOUSERS(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_UMODEIS(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_WHOISCHANOP(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_LUSEROP(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_SERVICE(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_UMODEUNKNOWNFLAG(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_LINKS(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOOPERHOST(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSQLINE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACEEND(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOTOPLEVEL(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_LUSERCLIENT(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_LUSERUNKNOWN(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ADMINLOC2(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSCLINE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ENDOFINVITELIST(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ENDOFLINKS(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOADMININFO(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_YOURESERVICE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ENDOFWHO(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NORECIPIENT(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ADMINLOC1(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_BADCHANNELKEY(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_BADMASK(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ENDOFWHOIS(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_SERVICEINFO(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACELINK(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOSUCHSERVICE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_LISTEND(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_INFOSTART(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSNLINE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ENDOFEXCEPTLIST(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSKLINE(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_BANLISTFULL(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_MOTDSTART(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACECONNECTING(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_MYINFO(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_USERSDISABLED(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ENDOFWHOWAS(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_YOUREBANNEDCREEP(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_MOTD(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSHLINE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_CLOSING(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NICKNAMEINUSE(String reply) {
    }
    
    public void RPL_TOPIC(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_ALREADYREGISTERED(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSSLINE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSLLINE(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOTEXTTOSEND(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACEOPERATOR(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_BADCHANMASK(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_CHANNELMODEIS(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_INVITELIST(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_UNIQOPIS(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_CHANNELISFULL(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_CANNOTSENDTOCHAN(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSBLINE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_WHOISCHANNELS(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSCOMMANDS(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_NONE(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOPRIVILEGES(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_BOUNCE(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_YOUWILLBEBANNED(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ENDOFNAMES(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACELOG(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOTONCHANNEL(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOMOTD(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACESERVICE(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOSUCHSERVER(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_USERONCHANNEL(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACECLASS(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_UNKNOWNCOMMAND(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TIME(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACEHANDSHAKE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACESERVER(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_STATSILINE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_SERVLIST(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACENEWTYPE(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_WHOWASUSER(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_WHOREPLY(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_NOPERMFORHOST(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_VERSION(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_USERS(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_LUSERME(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_UNAWAY(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACERECONNECT(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACEUNKNOWN(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_LISTSTART(String reply) throws ReplyHandlerException {
    }
    
    public void ERR_USERSDONTMATCH(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_EXCEPTLIST(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_YOUREOPER(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRACEUSER(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_WHOISUSER(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_WHOISSERVER(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ADMINEMAIL(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_TRYAGAIN(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_ADMINME(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_CREATED(String reply) throws ReplyHandlerException {
    }
    
    public void RPL_AWAY(String reply) throws ReplyHandlerException {
    }
    
}
